package com.xindaxin.sale.utils

import android.os.Environment


/**
 * 创建者：王统根
 * 时间：2018-07-28
 * 描述：sd卡的工具类
 */
object SDCardUtils {
    /**
     * 判断sd卡是否可用
     */
    fun isSDCardEnableByEnvironment(): Boolean {
        return Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
    }

    /**
     * 获取sd卡的地址
     */
    fun getSDCardPathByEnvironment(): String {
        return if (isSDCardEnableByEnvironment()) {
            Environment.getExternalStorageDirectory().absolutePath
        } else ""
    }

}