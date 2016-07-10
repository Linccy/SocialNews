package socialnews.linccy.com.socialnews;

import java.util.List;

/**
 * Created by Lcc on 2016/7/10.
 */

public class NewsListResponseJson {
    private int code;
    private String msg;
    private List<NewsItem> newslist;

    public NewsListResponseJson(int code, String msg, List<NewsItem> newslist) {
        this.code = code;
        this.msg = msg;
        this.newslist = newslist;
    }

    @Override
    public String toString() {
        return "NewsListResponseJson{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewsItem> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewsItem> newslist) {
        this.newslist = newslist;
    }
}
