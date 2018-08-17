package com.xindaxin.sale.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.TextView
import com.xindaxin.sale.R


/**
 * 创建者：王统根
 * 时间：2017-04-12
 * 描述：显示加载框的dialog工具类(不适配可能需要自定义)
 */

object ProgressDialogUtils {
    /**
     *
     */
    private var builder: AlertDialog.Builder? = null

    /**
     * dialog
     */
    private var alertDialog: AlertDialog? = null

    /**
     * 可编辑显示内容
     *
     * @param context
     * @param strId
     */
    @JvmOverloads
    fun showProgress(context: Context, strId: Int = R.string.hint_progress_default) {
        builder = AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_progress_loading, null)
        val textView = view.findViewById<TextView>(R.id.hint)
        textView.text = StringUtils.getString(strId)
        builder!!.setView(view)
        alertDialog = builder!!.create()
        alertDialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog!!.show()
    }

    /**
     * 显示没有提示消息的dialog
     *
     * @param context
     */
    fun showNoHintProgress(context: Context) {
        builder = AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_progress_no_hint_loading, null)
        builder!!.setView(view)
        alertDialog = builder!!.create()
        alertDialog!!.show()
    }

    /**
     * 隐藏dialog
     */
    fun hideProgress() {
        if (alertDialog != null && alertDialog!!.isShowing) {
            alertDialog!!.dismiss()
        }
    }
}

