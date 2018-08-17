package com.xindaxin.sale.utils

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.annotation.RequiresPermission
import android.telephony.TelephonyManager
import com.xindaxin.sale.base.BaseApplication


/**
 * 创建者：王统根
 * 时间：2018-07-28
 * 描述：网络的工具类
 */
object NetworkUtils {
    /**
     * 枚举类型,网络的类型
     */
    enum class NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    /**
     * 打开无线网设置界面
     */
    fun openWirelessSettings() {
        BaseApplication.instance.startActivity(
                Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }

    /**
     * 是否有网络连接
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    fun isConnected(): Boolean {
        val info = getActiveNetworkInfo()
        return info != null && info!!.isConnected
    }

    /**
     * 网络连接类型是否是WiFi
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    fun isWifiConnected(): Boolean {
        val cm = BaseApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return (cm.activeNetworkInfo != null && cm.activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI)
    }

    /**
     * 网络是否是4G
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    fun is4G(): Boolean {
        val info = getActiveNetworkInfo()
        return (info != null
                && info.isAvailable
                && info.subtype == TelephonyManager.NETWORK_TYPE_LTE)
    }

    /**
     * 获取连接网络的信息
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    private fun getActiveNetworkInfo(): NetworkInfo? {
        val manager = BaseApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return manager.activeNetworkInfo
    }
}