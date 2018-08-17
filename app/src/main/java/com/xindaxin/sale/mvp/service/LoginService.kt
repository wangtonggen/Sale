package com.xindaxin.sale.mvp.service

import com.xindaxin.sale.API.API
import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.HttpResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：登录的service
 */
interface LoginService {
    @FormUrlEncoded
    @POST(API.URL_LOGIN)
    fun login(@Field("username") userName: String, @Field("password") password: String, @Field("imobile") imobile: Int): Observable<HttpResponse<LoginBean>>

    @FormUrlEncoded
    @POST(API.URL_LOGIN)
    fun register(@Field("username") userName: String, @Field("password") password: String): Observable<HttpResponse<String>>
}