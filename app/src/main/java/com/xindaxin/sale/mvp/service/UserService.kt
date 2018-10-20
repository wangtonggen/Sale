package com.xindaxin.sale.mvp.service

import com.xindaxin.sale.API.API
import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.BaseObservable
import com.xindaxin.sale.mvp.base.HttpResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author: wtg by 2018/9/27 0027
 *
 *
 * @desc: 用户相关信息的service
 *
 **/
@Deprecated("已经用CommonService来代替")
interface UserService {

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST(API.URL_LOGIN)
    fun login(@Field("username") userName: String, @Field("password") password: String, @Field("imobile") imobile: Int): BaseObservable<LoginBean>

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST(API.URL_LOGIN)
    fun register(@Field("username") userName: String, @Field("password") password: String): Observable<HttpResponse<String>>
}