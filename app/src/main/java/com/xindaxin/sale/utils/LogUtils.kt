package com.xindaxin.sale.utils

import android.util.Log
import com.xindaxin.sale.BuildConfig

/**
 * Created by 王统根
 * Date 16/6/28
 * Desc 打印日志
 */
object LogUtils {

    fun e(tag: String, message: String?) {
        if (BuildConfig.LOG)
            Log.e(tag, message)
    }

    fun d(tag: String, message: String?) {
        if (BuildConfig.LOG)
            Log.e(tag, message)
    }
}
