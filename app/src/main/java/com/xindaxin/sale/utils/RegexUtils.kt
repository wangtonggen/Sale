package com.xindaxin.sale.utils

import com.xindaxin.sale.constant.RegexConstant
import java.util.regex.Pattern


/**
 * 创建者：王统根
 * 时间：2018-07-28
 * 描述：验证工具类
 */
object RegexUtils {
    /**
     * 简单验证手机号
     */
    fun isMobileSimple(input: String): Boolean = isMatch(RegexConstant.REGEX_MOBILE_SIMPLE, input)

    /**
     * 精确验证手机号
     */
    fun isMobileExact(input: String): Boolean = isMatch(RegexConstant.REGEX_MOBILE_EXACT, input)

    /**
     * 验证座机
     */
    fun isTel(input: String): Boolean = isMatch(RegexConstant.REGEX_TEL, input)

    /**
     * 15卡号
     */
    fun isIDCard15(input: String): Boolean = isMatch(RegexConstant.REGEX_ID_CARD15, input)

    /**
     * 18位卡号
     */
    fun isIDCard18(input: String): Boolean = isMatch(RegexConstant.REGEX_ID_CARD18, input)

    /**
     * 邮箱验证
     */
    fun isEmail(input: String): Boolean = isMatch(RegexConstant.REGEX_EMAIL, input)

    /**
     * url验证
     */
    fun isURL(input: String): Boolean = isMatch(RegexConstant.REGEX_URL, input)

    /**
     * 中文字符验证
     */
    fun isZh(input: String): Boolean = isMatch(RegexConstant.REGEX_ZH, input)


    /**
     * 验证日期
     * @param input String 日期
     * @param regex String 正则表达式 默认验证yyyy-MM-dd类型
     * @return Boolean
     */
    @JvmOverloads
    fun isDate(input: String,regex:String=RegexConstant.REGEX_DATE): Boolean = isMatch(regex, input)


    /**
     * 验证
     */
    private fun isMatch(regex: String, input: String?): Boolean = (!input.isNullOrEmpty() && Pattern.matches(regex, input))


}