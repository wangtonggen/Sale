package com.xindaxin.sale.utils

import android.support.annotation.StringRes

import com.xindaxin.sale.base.BaseApplication


/**
 * 创建者：王统根
 * 时间：2017-04-12
 * 描述：String的工具类
 */

object StringUtils {
    /**
     * 只能传入String的id
     *
     * @param strId
     * @return
     */
    fun getString(@StringRes strId: Int): String = BaseApplication.instance.resources.getString(strId)

    /**
     * 加密电话中间四位显示*
     *
     * @param mobile
     * @return
     */
    fun getEncodeMobile(mobile: String): String = mobile.substring(0, mobile.length - mobile.substring(3).length) + "****" + mobile.substring(7)

    /**
     * 字符串模板
     * @param hint String 提示信息
     * @param content String 内容
     * @return String 返回字符串内容
     */
    fun stringFormat(hint: String, content: String): String {
        return "$hint$content"
    }

    /**
     * 字符串模板
     * @param hintId int 提示信息的资源id
     * @param content String 内容
     * @return String 返回字符串内容
     */
    fun stringFormat(@StringRes hintId: Int, content: String): String {
        return stringFormat(getString(hintId), content)
    }

    /**
     * 字符串模板
     * @param hintId int 提示信息的资源id
     * @param contentId int 内容资源文件
     * @return String 返回字符串内容
     */
    fun stringFormat(@StringRes hintId: Int, @StringRes contentId: Int): String {
        return stringFormat(getString(hintId), getString(contentId))
    }

}
