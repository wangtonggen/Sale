package com.xindaxin.sale.utils

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * author: wtg by 2018/10/24 0024
 *
 * desc: 发送消息验证码倒计时
 *
 **/
object SendMessageCodeCountDownUtils {
    /**
     * 倒计时
     * @param stepTime Long 间隔的时间
     * @param totalTime Long 总共的时间
     * @param observer Observer<Long>
     */
    fun countDown(stepTime: Long, totalTime: Long, observer: Observer<Long>) {
        Observable.interval(0, stepTime, TimeUnit.SECONDS)
                .take(totalTime + 1)
                .map {
                    totalTime - it
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    /**
     * 正常计时 使用时要把observer 单独创建对象,便于关闭发送
     * @param stepTime Long 间隔的时间
     * @param observer Observer<Long>
     */
    fun timer(stepTime: Long, observer: Observer<Long>) {
        Observable.interval(0, stepTime, TimeUnit.SECONDS)
                .map {
                    it + 1
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}