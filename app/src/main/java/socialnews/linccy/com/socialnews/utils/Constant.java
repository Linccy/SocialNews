package socialnews.linccy.com.socialnews.utils;

/**
 * Created by Lcc on 2016/7/9.
 */

public class Constant {
    private int catid;//catid 新闻分类id 其中包含(1、2、3、4)表示 1是旅游 2是要闻 3是应用 4是游戏
    private int pagesize;//每次请求获取新闻的数量
    private String sid;//最后一条新闻的id（用于下拉刷新数据） ,新闻ID可以从返回值中获取 可选参数。
    public static String APIKET = "7ee4db22ac82d07de07019c5c7bade8f";
    private String url = "http://apis.baidu.com/cd_boco/chinanews/testnewsapi?query={'device':'android','catid':";

    public Constant(int catid, int pagesize, String sid) {
        this.catid = catid;
        this.pagesize = pagesize;
        this.sid = sid;
    }

    public Constant(int catid, int pagesize) {
        this.catid = catid;
        this.pagesize = pagesize;
    }

    public String getRefreshUrl() {
        sid = null;
        return url + catid + ",'pagesize':" + pagesize + "}";
    }

    public String getLoadUrl() {
        if (sid == null) {
            return url + catid + ",'pagesize':" + pagesize + "}";
        } else {
            return url + catid + ",'pagesize':" + pagesize + ",'sid':'" + sid + "'}";
        }
    }

    public String getUrl(int catid, int pagesize) {
        if (sid == null)
            return url + catid + ",'pagesize':" + pagesize + "}";
        else
            return url + catid + ",'pagesize':" + pagesize + ",'sid':'" + sid + "'}";
    }


    public String getUrl(int catid, int pagesize, String sid) {
        return url + catid + ",'pagesize':" + pagesize + ",'sid':'" + sid + "'}";
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
