package com.xindaxin.sale.utils

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import io.reactivex.functions.Function
import java.util.Locale


/**
 * 创建者：王统根
 * 时间：2018-07-28
 * 描述：日期的工具类
 */
object TimeUtils {
    @SuppressLint("SimpleDateFormat")
    val DEFAULT_FORMAT = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
    @SuppressLint("SimpleDateFormat")
    val DEFAULT_FORMAT_NO_HOUR = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
    @SuppressLint("SimpleDateFormat")
    val DEFAULT_FORMAT_NO_MINUTE = SimpleDateFormat("yyyy-MM-dd HH", Locale.CHINA)
    @SuppressLint("SimpleDateFormat")
    val DEFAULT_FORMAT_NO_SECOND = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA)

    /**
     * 时间格式化(可添加字符串格式化)
     */
    @JvmOverloads
    fun formatTime(obj: Any, format: SimpleDateFormat = DEFAULT_FORMAT, originalFormat: String? = null): String {
        return if (obj is String && originalFormat != null) {
            format.format(SimpleDateFormat(originalFormat, Locale.CHINA).parse(obj))
        } else format.format(obj)
    }
}