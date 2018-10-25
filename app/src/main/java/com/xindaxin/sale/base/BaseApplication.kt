package com.xindaxin.sale.base

import android.app.Application
import org.litepal.LitePal

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：baseApplication
 */
class BaseApplication : Application() {
    //定义常量
    companion object {
        lateinit var instance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        LitePal.initialize(this)
    }
}