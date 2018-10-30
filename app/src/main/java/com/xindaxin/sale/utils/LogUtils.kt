package com.xindaxin.sale.utils

import android.util.Log
import com.xindaxin.sale.BuildConfig

/**
 * Created by 王统根
 * Date 16/6/28
 * Desc 打印日志
 */
object LogUtils {

    private const val TAG = "sale"
    @JvmOverloads
    fun e(tag: String = TAG, message: Any?) {
        if (BuildConfig.LOG) {
            Log.e(tag, "$message")
        }
    }

    @JvmOverloads
    fun d(tag: String = TAG, message: Any?) {
        if (BuildConfig.LOG) {
            Log.e(tag, "$message")
        }
    }

    @JvmOverloads
    fun i(tag: String = TAG, message: Any?) {
        if (BuildConfig.LOG) {
            Log.i(tag, "$message")
        }
    }

    @JvmOverloads
    fun v(tag: String = TAG, message: Any?) {
        if (BuildConfig.LOG) {
            Log.v(tag, "$message")
        }
    }

    @JvmOverloads
    fun w(tag: String = TAG, message: Any?) {
        if (BuildConfig.LOG) {
            Log.w(tag, "$message")
        }
    }
}
