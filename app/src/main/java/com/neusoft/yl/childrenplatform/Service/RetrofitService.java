package com.neusoft.yl.childrenplatform.Service;

import com.neusoft.yl.childrenplatform.Bean.CheckBean;
import com.neusoft.yl.childrenplatform.Bean.CollectBean;
import com.neusoft.yl.childrenplatform.Bean.CommentBean;
import com.neusoft.yl.childrenplatform.Bean.CommodityIntroBean;
import com.neusoft.yl.childrenplatform.Bean.CompBean;
import com.neusoft.yl.childrenplatform.Bean.LoginBean;
import com.neusoft.yl.childrenplatform.Bean.PartitionBean;
import com.neusoft.yl.childrenplatform.Bean.RegisterBean;
import com.neusoft.yl.childrenplatform.Bean.TrendsBean;
import com.neusoft.yl.childrenplatform.Bean.UpUserBean;
import com.neusoft.yl.childrenplatform.Bean.UserCenterBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Kirito on 2017/11/25.
 */

public interface RetrofitService {
    //登录接口
    @GET("user/userLogin")
    Call<LoginBean> userLogin(@Query("telephone") String telephone,
                              @Query("password") String password);

    //注册接口
    @POST("user/userRegister")
    Call<RegisterBean> userRegister(@Query("telephone") String telephone,
                                    @Query("password") String password);

    //获取用户中心接口
    @GET("User/userInformation")
    Call<UserCenterBean> getUserInformation(@Query("id") String id);

    //修改用户昵称接口
    @POST("User/updateUsername")
    Call<UpUserBean> upUsername(@Query("id") String id,
                                @Query("username") String username);

    //修改用户个性签名接口
    @POST("User/updateUserIntro")
    Call<UpUserBean> upUserintro(@Query("id") String id,
                                 @Query("intro") String intro);

    //修改用户性别接口
    @POST("User/updateUserSex")
    Call<UpUserBean> upUsersex(@Query("id") String id,
                               @Query("sex") String sex);

    //获取用户收藏接口
    @GET("User/userCollect")
    Call<List<CollectBean>> getUserCollect(@Query("id") String id);

    //获取推荐-综合接口
    @GET("Home/comp")
    Call<List<CompBean>> getCompList();

    //获取分类信息接口，1为食物，2为娱乐，3为衣着，4为培训
    @GET("Home/type")
    Call<List<CompBean>> getTypeList(@Query("id") int id);

    //获取商品详情接口
    @GET("Commodity/CommodityDetail")
    Call<CompBean> getCommodityDetail(@Query("commodity_id") String id);

    //获取商品评论接口
    @GET("Comment/CommodityComment")
    Call<List<CommentBean>> getCommodityComment(@Query("commodity_id") String commodity_id);

    //获取商品详情接口
    @GET("Commodity/CommodityIntro")
    Call<CommodityIntroBean> getCommodityIntro(@Query("commodity_id") String commodity_id);

    //判断是否收藏
    @GET("Collect/IsCollect")
    Call<CheckBean> getIsCollect(@Query("commodity_id") String commodity_id,
                                     @Query("user_id") String user_id);

    //添加&取消收藏
    @GET("Collect/Collect")
    Call<CheckBean> getCollect(@Query("commodity_id") String commodity_id,
                                     @Query("user_id") String user_id);

    //判断是否关注
    @GET("Follow/IfFollow")
    Call<CheckBean> getIsFollow(@Query("company_id") int company_id,
                                @Query("user_id") String user_id);

    //添加&取消关注
    @GET("Follow/Follow")
    Call<CheckBean> getFollow(@Query("company_id") int company_id,
                                @Query("user_id") String user_id);

    //获取分类列表
    @GET("Partition/GetPartition")
    Call<List<PartitionBean>> getPartition();

    //获取动态列表
    @GET("Trends/GetTrends")
    Call<List<TrendsBean>> getTrends();
}
