package com.xindaxin.sale.mvp.service

import com.xindaxin.sale.mvp.base.BaseObservable
import com.xindaxin.sale.mvp.base.HttpResponse
import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * author: wtg by 2018/10/19 0019
 *
 *
 * desc: 统一的请求接口 目前用到的就这么多,需要的时候按需添加,有需要的继承添加
 *
 **/
interface CommonService {
    /**
     * 统一的post方式请求 @FileMap其实和@File效果一样 @FileMap是@File的集合
     * @param url 请求的接口
     * @param params 也可以添加数组方式 只要把key定义成字段+[] 例如orderIds[] value 添加相应的List<Object>
     * @return BaseObservable<T>
     */
    @FormUrlEncoded
    @POST()
    fun <T> requestPost(@Url url: String, @FieldMap params: Map<String, Any>): BaseObservable<T>

    /**
     * 统一的get方式请求?后面没有参数的情况
     * @param url String 请求的接口
     * @return BaseObservable<T>
     */
    @GET
    fun <T> requestGet(@Url url: String): BaseObservable<T>

    /**
     * 有参数的get请求(参数在?之后)
     * @param url String
     * @param params Map<String, Any> 参数
     */
    @GET
    fun <T> requestQuery(@Url url: String, @QueryMap params: Map<String, Any>): BaseObservable<T>

    /**
     * 统一的下载文件
     *
     * @param url 请求的接口
     * @return
     */
    @Streaming
    @GET
    fun download(@Url url: String): Observable<ResponseBody>

    /**
     * 文件上传(单文件或者多文件)
     * @param url 请求的接口
     * @param params 参数
     * @return
     */
    @Multipart
    @POST()
    fun <T> uploadFiles(@Url url: String, @PartMap params: Map<String, RequestBody>): Observable<HttpResponse<T>>
}