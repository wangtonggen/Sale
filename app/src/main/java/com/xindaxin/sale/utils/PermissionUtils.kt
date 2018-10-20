package com.xindaxin.sale.utils

import android.annotation.TargetApi
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import com.xindaxin.sale.listener.OnPermissionListener

/**
 * @author: wtg by 2018/10/7 0007
 *
 *
 * @desc: 权限的工具类（增加添加权限去重）
 *
 **/
class PermissionUtils private constructor() {
    private var mOnPermissionListener: OnPermissionListener? = null
    //用来存储权限
    private var localPermissions = mutableListOf<String>()

    companion object {
        private var instance: PermissionUtils? = null
        fun getInstance(): PermissionUtils {
            if (instance == null) {
                synchronized(PermissionUtils::class.java) {
                    if (instance == null) {
                        instance = PermissionUtils()
                    }
                }
            }
            return instance!!
        }
    }

    /**
     * 添加权限
     * @param permission String
     * @return PermissionUtils1
     */
    fun addPermission(permission: String): PermissionUtils {
        if (!localPermissions.contains(permission))
            localPermissions.add(permission)
        return this
    }

    /**
     * 添加权限
     * @param permissions List<String>
     * @return PermissionUtils1
     */
    fun addPermission(permissions: List<String>): PermissionUtils {
        permissions.forEach {
            if (!localPermissions.contains(it))
                localPermissions.add(it)
        }
        return this
    }

    @TargetApi(Build.VERSION_CODES.M)
    @JvmOverloads
    fun applyPermission(activity: Activity, requestCode: Int, listener: OnPermissionListener, permissions: List<String>? = null) {
        mOnPermissionListener = listener
        if (!versionCheck()) {
            listener.onPermissionGranted()
            return
        }
        if (permissions != null)
            permissions!!.forEach {
                if (!localPermissions.contains(it))
                    localPermissions.add(it)
            }
        ActivityCompat.requestPermissions(activity, localPermissions.toTypedArray(), requestCode)
    }

    /**
     * 判断是否授权
     *
     * @param grantResults
     * @return
     */
    private fun verifyPermissions(grantResults: IntArray?): Boolean {
        for (grantResult in grantResults!!) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    /**
     * 请求权限的结果
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        LogUtils.e("tag", "进来了")
        if (mOnPermissionListener != null) {
            if (verifyPermissions(grantResults)) {
                localPermissions.clear()
                mOnPermissionListener!!.onPermissionGranted()//申请成功
            } else {
                mOnPermissionListener!!.onPermissionDenied()//申请失败
            }
        }
    }

    /**
     * 判断版本是否需要申请权限
     * @return Boolean true 需要申请权限
     */
    private fun versionCheck(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }
}