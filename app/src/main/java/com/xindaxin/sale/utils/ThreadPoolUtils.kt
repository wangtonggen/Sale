package com.xindaxin.sale.utils

import com.xindaxin.sale.constant.ThreadPoolConstant
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * 创建者：王统根
 * 时间：2018-07-28
 * 描述：线程池管理类
 */
object ThreadPoolUtils {
    private var mInstance: ThreadPollProxy? = null
    fun getInstance(): ThreadPollProxy {
        if (mInstance == null) {
            synchronized(ThreadPollProxy::class.java) {
                if (mInstance == null) {
                    mInstance = ThreadPollProxy(ThreadPoolConstant.COER_POOL_SIZE, ThreadPoolConstant.MAX_POOL_SIZE, ThreadPoolConstant.KEEP_ALIVE_TIME)
                }
            }
        }
        return mInstance!!
    }


    //通过ThreadPoolExecutor的代理类来对线程池的管理
    open class ThreadPollProxy {
        private var poolExecutor: ThreadPoolExecutor//线程池执行者 ，java内部通过该api实现对线程池管理
        private var corePoolSize: Int
        private var maximumPoolSize: Int
        private var keepAliveTime: Long

        constructor(corePoolSize: Int, maximumPoolSize: Int, keepAliveTime: Long) {
            this.corePoolSize = corePoolSize
            this.maximumPoolSize = maximumPoolSize
            this.keepAliveTime = keepAliveTime
            poolExecutor = ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, LinkedBlockingQueue(), Executors.defaultThreadFactory())
        }

        fun execute(r: Runnable) {
            poolExecutor.execute(r)
        }
    }
}