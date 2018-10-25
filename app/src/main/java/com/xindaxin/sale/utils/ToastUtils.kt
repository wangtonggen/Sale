package com.xindaxin.sale.utils

import android.support.annotation.StringRes
import android.widget.Toast

import com.xindaxin.sale.base.BaseApplication

/**
 * 提示类
 */
object ToastUtils {

    /**
     * 长时间toast
     * @param message 显示的内容
     */
    fun showLongToast(message: String) = Toast.makeText(BaseApplication.instance, message, Toast.LENGTH_LONG).show()


    /**
     * 短时间toast
     *
     * @param resId 显示内容的资源id
     */
    fun showLongToast(@StringRes resId: Int) = showLongToast(StringUtils.getString(resId))

    /**
     * 短时间toast
     *
     * @param message 要显示的内容
     */
    fun showShortToast(message: String) = Toast.makeText(BaseApplication.instance, message, Toast.LENGTH_SHORT).show()

    /**
     * 短时间toast
     *
     * @param resId 要显示内容的资源id
     */
    fun showShortToast(@StringRes resId: Int) = showShortToast(StringUtils.getString(resId))


    /**
     * 功能暂未开放提示
     */
    fun showFunctionDispartToast() = showShortToast("功能暂未开放")


    /**
     * 数据为空
     */
    fun showNullToast() = showShortToast("输入的内容不能为空")


    /**
     * 无网络
     */
    fun showNoNetToast() = showShortToast("暂无网络,请检查下网络")

    /**
     * 没有数据
     */
    fun showNoDataToast() = showShortToast("暂无更多数据")


    /**
     * 失败的toast
     */
    fun showErrorToast() = showShortToast("未知错误")

}
