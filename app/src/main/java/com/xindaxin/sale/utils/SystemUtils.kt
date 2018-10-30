package com.xindaxin.sale.utils

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.xindaxin.sale.base.BaseApplication
import org.jetbrains.annotations.NotNull

/**
 * author: wtg by 2018/10/30 0030
 *
 * desc: 系统相关操作的工具类
 *
 **/
object SystemUtils {
    /**
     * 拨打电话(跳转到拨打电话界面)
     * @param phoneNum String
     */
    fun dialPhone(@NotNull phoneNum: String) {
        if (phoneNum.isEmpty()) {
            ToastUtils.showShortToast("手机号不能为空")
            return
        }
        val intent = Intent(Intent.ACTION_DIAL)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val data = Uri.parse("tel:$phoneNum")
        intent.data = data
        BaseApplication.instance.startActivity(intent)
    }

    /**
     * 拨打电话(直接拨打电话)
     * @param phoneNum String
     */
    fun callPhone(@NotNull phoneNum: String) {
        if (phoneNum.isEmpty()) {
            ToastUtils.showShortToast("手机号不能为空")
            return
        }
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val data = Uri.parse("tel:$phoneNum")
            intent.data = data
            BaseApplication.instance.startActivity(intent)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }

    }

    /**
     * 获取versionCode
     *
     * @return
     */
    fun getVersionCode(): Int {
        var versionCode = 0
        try {
            val packageManager = BaseApplication.instance.packageManager
            versionCode = packageManager.getPackageInfo(BaseApplication.instance.packageName, 0).versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionCode
    }

    /**
     * 获取versonName
     *
     * @return
     */
    fun getVersionName(): String {
        var versionName = ""
        try {
            versionName = BaseApplication.instance.packageManager.getPackageInfo(BaseApplication.instance.packageName, 0).versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionName
    }

    /**
     * 获取appName
     *
     * @return
     */
    fun getAPPName(): String? {
        try {
            val packageManager = BaseApplication.instance.packageManager
            val packageInfo = packageManager.getPackageInfo(BaseApplication.instance.packageName, 0)
            val labelRes = packageInfo.applicationInfo.labelRes
            return BaseApplication.instance.resources.getString(labelRes)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 获取一个随机数
     * @return Int
     */
    fun getRandomNumber(): Int {
        return (System.currentTimeMillis() % 10000).toInt()
    }
}