package socialnews.linccy.com.socialnews.utils;

import java.util.List;

/**
 * Created by Lcc on 2016/7/10.
 */

public class NewsListResponseJson {
    private int error;
    private String msg;
    private List<NewsItem> data;

    public NewsListResponseJson(int error, String msg, List<NewsItem> data) {
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "NewsListResponseJson{" +
                "error=" + error +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewsItem> getData() {
        return data;
    }

    public void setData(List<NewsItem> data) {
        this.data = data;
    }
}
