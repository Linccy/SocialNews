package socialnews.linccy.com.socialnews.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import butterknife.BindView;
import socialnews.linccy.com.socialnews.R;

public class NewsDetailActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    String link;
    RequestQueue mQueue;

    @Override
    protected void initData() {
        super.initData();
//        toolbar.setTitleTextColor(Color.WHITE);

        toolbar.setTitle("新闻正文");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mQueue = Volley.newRequestQueue(this);
        link = (String) getIntent().getSerializableExtra("link");
//        getNewDetail(link);
//        if (link != null) {
//            webview.loadUrl();
//        }
        WebSettings webSettings = webview.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webview.loadUrl(link);
        //设置Web视图
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    /**
     * 获取新闻页面,暂时未用到
     *
     * @param link：完整的新闻正文URL
     */
    private void getNewDetail(String link) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewsDetailActivity.this, "请求数据失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_share:
                Toast.makeText(NewsDetailActivity.this, link, Toast.LENGTH_SHORT).show();
                Intent shareIntent = new Intent();
                shareIntent.putExtra(Intent.EXTRA_STREAM, link);
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, "分享到"));
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_newsdetail_title, menu);
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void onClick(View v) {

    }

}
