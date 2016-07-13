package socialnews.linccy.com.socialnews.utils;

/**
 * Created by Lcc on 2016/7/9.
 */


/**
 * 新闻信息类，Item
 */
public class NewsItem {

    private String id;
    private String title;//标题
    private String link;//内容地址
    private String descr;//描述
    private String refinfo;//来源
    private String thumb;//图片地址
    private String time;//时间
    private String viewnum;//意义不明

    public NewsItem(String id, String title, String link, String descr, String refinfo, String thumb, String time, String viewnum) {
        this.id = id;
        this.title = CharacterConversion.convertUnicode(title);
        this.link = link;
        this.descr = CharacterConversion.convertUnicode(descr);
        this.refinfo = CharacterConversion.convertUnicode(refinfo);
        this.thumb = thumb;
        this.time = time;
        this.viewnum = viewnum;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "descr='" + descr + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", refinfo='" + refinfo + '\'' +
                ", thumb='" + thumb + '\'' +
                ", time='" + time + '\'' +
                ", viewnum='" + viewnum + '\'' +
                '}';
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRefinfo() {
        return refinfo;
    }

    public void setRefinfo(String refinfo) {
        this.refinfo = refinfo;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewnum() {
        return viewnum;
    }

    public void setViewnum(String viewnum) {
        this.viewnum = viewnum;
    }
}
