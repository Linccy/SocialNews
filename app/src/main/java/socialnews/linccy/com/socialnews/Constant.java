package socialnews.linccy.com.socialnews;

/**
 * Created by Lcc on 2016/7/9.
 */

public class Constant {
    public static final int num = 10;//每次获取10条
    public static final String APIKET = "7ee4db22ac82d07de07019c5c7bade8f";
    public static final String SocialNewsURL = "http://apis.baidu.com/cd_boco/chinanews/testnewsapi?query={'device':'android','catid':1,'pagesize':10,'sid':'11142'}";
    public static final String GuoeiNewsURL = "http://api.tianapi.com/guonei/?key=" + APIKET + "&num=" + num;
    public static final String WorldNewsURL = "http://api.tianapi.com/world/?key=" + APIKET + "&num=" + num;
    public static final String HuaBianNewsURL = "http://api.tianapi.com/huabian" + APIKET + "&num=" + num;
    public static final String TiYuNewsURL = "http://api.tianapi.com/tiyu/?key=" + APIKET + "&num=" + num;
    public static final String KeJiNewsURL = "http://api.tianapi.com/keji/?key=" + APIKET + "&num=" + num;
    public static final String HealthNewsURL = "http://api.tianapi.com/health/?key=" + APIKET + "&num=" + num;
}
