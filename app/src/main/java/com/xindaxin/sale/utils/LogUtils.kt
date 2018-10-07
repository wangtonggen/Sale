package com.xindaxin.sale.utils

import android.util.Log
import com.xindaxin.sale.BuildConfig

/**
 * Created by 王统根
 * Date 16/6/28
 * Desc 打印日志
 */
object LogUtils {

    fun e(tag: String, message: Any?) {
        if (BuildConfig.LOG) {
            var msg = "$message"
            Log.e(tag, msg)
        }
    }

    fun d(tag: String, message: Any?) {
        if (BuildConfig.LOG) {
            var msg = "$message"
            Log.e(tag, msg)
        }
    }
}
