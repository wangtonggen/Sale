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
     * 简单验证电话
     */
    fun isMobileSimple(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_MOBILE_SIMPLE, input)
    }

    /**
     * 精确验证电话
     */
    fun isMobileExact(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_MOBILE_EXACT, input)
    }

    /**
     * 验证手机号
     */
    fun isTel(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_TEL, input)
    }

    /**
     * 15卡号
     */
    fun isIDCard15(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_ID_CARD15, input)
    }

    /**
     * 18位卡号
     */
    fun isIDCard18(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_ID_CARD18, input)
    }

    /**
     * 邮箱验证
     */
    fun isEmail(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_EMAIL, input)
    }

    /**
     * url验证
     */
    fun isURL(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_URL, input)
    }

    /**
     * 中文字符验证
     */
    fun isZh(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_ZH, input)
    }


    /**
     * 日期验证 yyyy-mm-dd
     */
    fun isDate(input: String): Boolean {
        return isMatch(RegexConstant.REGEX_DATE, input)
    }


    /**
     * 验证
     */
    private fun isMatch(regex: String, input: String?): Boolean {
        return input != null && input.isNotEmpty() && Pattern.matches(regex, input)
    }

}