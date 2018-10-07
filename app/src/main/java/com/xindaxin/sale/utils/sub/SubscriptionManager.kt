package com.xindaxin.sale.utils.sub

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author: wtg by 2018/9/10 0010
 * @desc: rxjava2+retrofit2订阅关系的处理
 */
class SubscriptionManager private constructor() : SubscriptionHelper {
    //    private var map: Map<String, CompositeDisposable>? = null//通过map关联
    private var mDisposables: CompositeDisposable? = null

    init {

//        if (map == null) {
//            map = HashMap()
//        }
        if (mDisposables == null) {
            mDisposables = CompositeDisposable()
        }
    }

    override fun addSub(disposable: Disposable) {
        if (mDisposables != null) {
            mDisposables!!.add(disposable)
        }
    }

    override fun cancelSub(disposable: Disposable) {
        if (mDisposables != null) {
            mDisposables!!
            mDisposables!!.delete(disposable)
        }
    }

    override fun cancelAll() {
        if (mDisposables != null) {
            mDisposables!!.clear()
        }
    }

    companion object {
        var subscriptionManager: SubscriptionManager? = null

        val instance: SubscriptionManager
            get() {
                if (subscriptionManager == null) {
                    synchronized(SubscriptionManager::class.java) {
                        if (subscriptionManager == null) {
                            subscriptionManager = SubscriptionManager()
                        }
                    }
                }
                return subscriptionManager!!
            }
    }
}
