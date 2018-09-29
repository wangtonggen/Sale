package com.xindaxin.sale.mvp.base

import com.xindaxin.sale.utils.LogUtils
import com.xindaxin.sale.utils.ToastUtils
import com.xindaxin.sale.utils.sub.SubscriptionManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：数据/错误统一处理
 */
abstract class BaseObserver<T> : Observer<HttpResponse<T>> {
    private val TAG = javaClass.simpleName
    private lateinit var d: Disposable
    override fun onComplete() {
        complete()
        SubscriptionManager.instance.cancelSub(d)
    }

    override fun onSubscribe(d: Disposable) {
        this.d = d
        SubscriptionManager.instance.addSub(d)
    }

    override fun onNext(t: HttpResponse<T>) {//数据请求成功的统一处理
        if (t.success) {
            success(t)
        } else {//数据请求的为false的情况
            ToastUtils.showShortToast(t.msg)
        }
    }

    override fun onError(e: Throwable) {
        SubscriptionManager.instance.cancelSub(d)
        error()
        LogUtils.e(TAG, e.message!!.toString())//打印错误
        when (e) {//异常统一处理
            is HttpException -> {//网络错误
//               ToastUtils.showNetError()
            }
            else -> ToastUtils.showErrorToast()
        }
    }

    /**
     * 数据请求完成的操作(填充数据)
     */
    abstract fun success(data: HttpResponse<T>)

    /**
     * 请求错误的一些操作(例如关闭dialog)
     */
    abstract fun error()

    /**
     * 数据请求完成的一些操作(例如关闭dialog)
     */
    abstract fun complete()

}