package com.xindaxin.sale.mvp.base

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：带显示和隐藏dialog的view的基类
 */
interface IBaseDialogView : IBaseView {
    /**
     * 显示dialog
     */
    fun showDialog()

    /**
     * 隐藏dialog
     */
    fun cancelDialog()
}