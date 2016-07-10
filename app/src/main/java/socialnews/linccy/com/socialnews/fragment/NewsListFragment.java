package socialnews.linccy.com.socialnews.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import socialnews.linccy.com.socialnews.utils.Constant;
import socialnews.linccy.com.socialnews.utils.NewsItem;
import socialnews.linccy.com.socialnews.adapter.NewsItemAdapter;
import socialnews.linccy.com.socialnews.utils.NewsListResponseJson;
import socialnews.linccy.com.socialnews.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsListFragment extends BaseFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static List<NewsItem> newsItems = new ArrayList<>();
    RequestQueue mQueue;

    @BindView(R.id.section_label)
    TextView textView;
    @BindView(R.id.recyclerView_NewsList)
    RecyclerView mRecyclerView;

    public NewsListFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsListFragment newInstance(int sectionNumber) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initData() {
        super.initData();
        mQueue = Volley.newRequestQueue(getContext());
        textView.setText("fuck");
        getNewsData(Constant.SocialNewsURL);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new NewsItemAdapter(newsItems));

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
                newsItems = newsListJsonObject.getNewslist();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (newsItems == null) {
                    System.out.print("aaaaaaaaa");
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("apikey", Constant.APIKET);
                return headers;
            }
        };
        if (newsItems == null) {
            System.out.print("aaaaaaaaa");
        }
        mQueue.add(stringRequest);
        mQueue.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onClick(View v) {

    }
}
