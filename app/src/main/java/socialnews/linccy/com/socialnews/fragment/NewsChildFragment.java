package socialnews.linccy.com.socialnews.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import socialnews.linccy.com.socialnews.R;
import socialnews.linccy.com.socialnews.adapter.NewsItemAdapter;
import socialnews.linccy.com.socialnews.utils.Constant;
import socialnews.linccy.com.socialnews.utils.NewsItem;
import socialnews.linccy.com.socialnews.utils.NewsListResponseJson;
import socialnews.linccy.com.socialnews.view.SwipeLoadRefreshLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsChildFragment extends BaseFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    Constant constant;
    private List<NewsItem> newsItems = new ArrayList<>();
    RequestQueue mQueue;
    private int sectionNumber;
    private boolean action;//true表示刷新，false表示加载更多
    private boolean isVisibleToUser;//当前UI是否可见
    NewsItemAdapter adapter;
    @BindView(R.id.sl)
    SwipeLoadRefreshLayout sl;
    @BindView(R.id.section_label)
    TextView textView;
    @BindView(R.id.recyclerView_NewsList)
    RecyclerView mRecyclerView;
    ProgressDialog progressDialog;

    public NewsChildFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
//    public static NewsChildFragment newInstance(int sectionNumber1) {
//        NewsChildFragment fragment = new NewsChildFragment();
//        fragment.sectionNumber = sectionNumber1;
//        Bundle args = new Bundle();
//        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//        fragment.setArguments(args);
//        return fragment;
//    }
    @Override
    protected void initData() {
        super.initData();
        sectionNumber = getArguments().getInt("STATE");
//        textView.setText("fuck");
        sl.setColorSchemeColors(R.color.gray, R.color.colorPrimary);
        Bundle bundle = new Bundle();
        constant = new Constant(sectionNumber, 20);
        mQueue = Volley.newRequestQueue(getContext());
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("数据加载中....");
        progressDialog.show();
        if (isVisibleToUser) {
            progressDialog.cancel();
        }
        getNewsData(constant.getRefreshUrl());
        adapter = new NewsItemAdapter(newsItems);
        mRecyclerView.setAdapter(adapter);

    }

    /**
     * 获取网络数据 新闻卡片
     */
    private void getNewsData(String NewsType) {
        String URL = NewsType;//国内新闻列表
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            Gson gson = new Gson();

            @Override
            public void onResponse(String response) {
                NewsListResponseJson newsListJsonObject = gson.fromJson(response, NewsListResponseJson.class);
                if (action) {//刷新时的操作
                    newsItems = newsListJsonObject.getData();
                    adapter.notifyDataSetChanged();
                    sl.setRefreshing(false);
                } else {//加载更多时的操作
                    newsItems.addAll(newsListJsonObject.getData());
                    adapter.notifyDataSetChanged();
                    sl.setLoading(false);
                }
                constant.setSid(newsItems.get(newsItems.size() - 1).getId());//设置最后一条新闻的id用于加载更多
                progressDialog.cancel();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("网络错误", "104");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("apikey", Constant.APIKET);
                return headers;
            }
        };
        mQueue.add(stringRequest);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {//在这里判断UI是否可见
        this.isVisibleToUser = isVisibleToUser;
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_child;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void setListener() {
        super.setListener();
        sl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setIsRefresh();
                getNewsData(constant.getRefreshUrl());
            }
        });
        sl.setOnLoadListener(new SwipeLoadRefreshLayout.OnLoadListener() {

            @Override
            public void onLoad() {
//                Toast.makeText(getContext(), "拉到底了", Toast.LENGTH_SHORT).show();
                setIsLoad();
                sl.setLoading(true);
                getNewsData(constant.getLoadUrl());
            }
        });
    }


    public void setIsRefresh() {
        this.action = true;
    }

    public void setIsLoad() {
        this.action = false;
    }
}
