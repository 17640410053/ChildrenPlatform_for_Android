package com.neusoft.yl.childrenplatform;

/**
 * Created by Kirito on 2017/11/25.
 */

public class Const {
    //API接口
    public static String BASE_URL = "http://192.168.191.1/ChildrenPlatform/api.php/Api/"; //正式接口
    public static String T_BASE_URL = "http://127.0.0.1/ChildrenPlatform/api.php/Api/"; //测试接口
    //图片地址头
    public static String PIC_URL = "http://192.168.191.1/ChildrenPlatform/Public/uploads/";

    public final static int USERLOGIN = 1;
    public final static int USERREGISTER = 2;
    public final static int GETCOMPLIST = 3;
    public final static int GETUSERINFORMATION = 4;
    public final static int GETTYPELIST = 5;
    public final static int UPUSERNAME = 6;
    public final static int UPUSERINTRO = 7;
    public final static int UPUSERSEX = 8;
    public final static int GETUSERCOLLECT = 9;
    public final static int GETCOMMODITYDETAIL = 10;
    public final static int GETCOMMODITYCOMMENT = 11;
    public final static int GETCOMMODITYINTRO = 12;
    public final static int ISCOLLECT = 13;
    public final static int COLLECT = 14;
    public final static int ISFOLLOW = 15;
    public final static int FOLLOW = 16;
    public final static int GETPARTITION = 17;
    public final static int GETTRENDS = 18;
}
