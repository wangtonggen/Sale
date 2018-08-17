package com.xindaxin.sale.utils

import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.xindaxin.sale.listener.OnPermissionListener
import java.util.ArrayList

/**
 * 创建者：王统根
 * 时间：2018-07-28
 * 描述：权限的工具类
 */
object PermissionUtils {
    //录制视频权限
    private val PERMISSION_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO
    //获取联系人权限
    private val PERMISSION_READ_CONTACTS = Manifest.permission.READ_CONTACTS
    //电话状态的权限
    private val PERMISSION_READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE
    //打电话权限
    private val PERMISSION_CALL_PHONE = Manifest.permission.CALL_PHONE
    //手机摄像头的权限
    private val PERMISSION_CAMERA = Manifest.permission.CAMERA
    //获取位置的权限
    private val PERMISSION_ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
    private val PERMISSION_ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION
    //读取内存卡的权限
    private val PERMISSION_READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE
    //写入内存卡的权限
    private val PERMISSION_WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE
    //    private static String[] strPermissions;
    private var mOnPermissionListener: OnPermissionListener? = null
    private var mRequestCode = -1

    /**
     * 判断是否是当前版本是否大于api23版本
     *
     * @param activity
     * @param requestCode
     * @param permissions
     * @param listener
     */
    fun requestPermissions(activity: Activity, requestCode: Int, permissions: Array<String>, listener: OnPermissionListener) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//判断是否需要申请权限
            applyPermission(activity, requestCode, permissions, listener)
        } else {//如果低于6.0版本直接申请成功
            listener.onPermissionGranted()
        }
    }

    /**
     * 获取所有需要的权限
     *
     * @param activity
     * @param requestCode
     * @param listener
     */
    fun requestAllPermissions(activity: Activity, requestCode: Int, listener: OnPermissionListener) {
        val allPre = arrayOf(PERMISSION_RECORD_AUDIO, PERMISSION_CALL_PHONE, PERMISSION_CAMERA, PERMISSION_ACCESS_FINE_LOCATION, PERMISSION_ACCESS_COARSE_LOCATION, PERMISSION_READ_EXTERNAL_STORAGE, PERMISSION_WRITE_EXTERNAL_STORAGE, PERMISSION_READ_PHONE_STATE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//判断是否需要申请权限
            applyPermission(activity, requestCode, allPre, listener)
        } else {//如果低于6.0版本直接申请成功
            listener.onPermissionGranted()
        }
    }

    /**
     * 申请权限
     *
     * @param activity
     * @param requestCode
     * @param permissions
     * @param listener
     */
    @TargetApi(Build.VERSION_CODES.M)
    private fun applyPermission(activity: Activity, requestCode: Int, permissions: Array<String>, listener: OnPermissionListener) {
        if (activity is Activity) {
            mOnPermissionListener = listener
            val deniedPermissions = getDeniedPermissions(activity, *permissions)
            if (deniedPermissions.size > 0) {
                mRequestCode = requestCode
                ActivityCompat.requestPermissions(activity,
                        permissions,
                        requestCode)
            } else {
                if (mOnPermissionListener != null)
                    mOnPermissionListener!!.onPermissionGranted()
            }
        } else {
            throw RuntimeException("Context must be an Activity")
        }
    }

    /**
     * 单个权限的申请
     *
     * @param
     * @param requestCode
     * @param permissions
     * @param listener
     */
    fun requestPermissions(activity: Activity, requestCode: Int, permissions: String, listener: OnPermissionListener) {
        requestPermissions(activity, requestCode, arrayOf(permissions), listener)
    }

    /**
     * 请求权限的结果
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (mRequestCode != -1 && requestCode == mRequestCode) {
            if (mOnPermissionListener != null) {
                if (verifyPermissions(grantResults)) {
                    mOnPermissionListener!!.onPermissionGranted()//申请成功
                } else {
                    mOnPermissionListener!!.onPermissionDenied()//申请失败
                }
            }
        }
    }

    /**
     * @param context
     * @param permissions
     * @return
     */
    private fun getDeniedPermissions(context: Context, vararg permissions: String): List<String> {
        val deniedPermissions = ArrayList<String>()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permission)
            }
        }
        return deniedPermissions
    }

    /**
     * 判断是否授权
     *
     * @param grantResults
     * @return
     */
    private fun verifyPermissions(grantResults: IntArray): Boolean {
        for (grantResult in grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }
}