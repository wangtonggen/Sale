package com.xindaxin.sale.listener

/**
 * 创建者：王统根
 * 时间：2017-07-29
 * 描述：权限回调接口
 */

interface OnPermissionListener {
    /**
     * 权限申请成功
     */
    fun onPermissionGranted()

    /**
     * 权限申请失败
     */
    fun onPermissionDenied()
}
