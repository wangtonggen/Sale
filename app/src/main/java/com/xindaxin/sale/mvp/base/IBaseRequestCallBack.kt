package com.xindaxin.sale.mvp.base

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：请求数据反馈的接口
 */
@Deprecated("已经用封装的BaseObserver来代替")
interface IBaseRequestCallBack<T> {

    /**
     * 数据请求成功
     */
    fun requestSuccess(data: HttpResponse<T>)

    /**
     * 当请求错误的时候
     */
    fun requestError()

    /**
     * 当请求完成的时候
     */
    fun requestComplete()
}