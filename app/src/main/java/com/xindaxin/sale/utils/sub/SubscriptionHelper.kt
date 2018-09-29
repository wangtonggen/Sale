package com.xindaxin.sale.utils.sub

import io.reactivex.disposables.Disposable

/**
 * @author: wtg by 2018/9/10 0010
 * @desc: 订阅类的管理
 */
interface SubscriptionHelper {
    /**
     * 添加订阅
     *
     * @param disposable
     */
    fun addSub(disposable: Disposable)

    /**
     * 取消单个订阅
     *
     * @param disposable
     */
    fun cancelSub(disposable: Disposable)

    /**
     * 取消所有的订阅
     */
    fun cancelAll()
}
