package com.xindaxin.sale.ui.activity

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xindaxin.sale.R
import com.xindaxin.sale.listener.OnPermissionListener
import com.xindaxin.sale.utils.LogUtils
import com.xindaxin.sale.utils.PermissionUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionUtils.getInstance().addPermission(Manifest.permission.READ_CONTACTS).addPermission(Manifest.permission.READ_PHONE_STATE).addPermission(Manifest.permission.CALL_PHONE).applyPermission(this,2,object : OnPermissionListener{
            override fun onPermissionGranted() {//权限申请成功
                LogUtils.e("tag","成功:")
            }

            override fun onPermissionDenied() {//权限申请失败
                LogUtils.e("tag","失败")
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        PermissionUtils.getInstance().onRequestPermissionsResult(requestCode,permissions,grantResults)
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
