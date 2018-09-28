package com.xindaxin.sale.utils

import org.junit.Test

import org.junit.Assert.*

/**
 * @author: wtg by 2018/9/28 0028
 * @desc:
 */
class RegexUtilsTest {

    @Test
    fun isMobileSimple() {
        print(RegexUtils.isMobileSimple("15727960191"))
    }

    @Test
    fun isMobileExact() {
        print(RegexUtils.isMobileExact("15727960191"))
    }

    @Test
    fun isTel() {
        print(RegexUtils.isTel("0579524698"))
    }

    @Test
    fun isIDCard15() {
        print(RegexUtils.isIDCard15(""))
    }

    @Test
    fun isIDCard18() {
        print(RegexUtils.isIDCard18("412326199005146033"))
    }

    @Test
    fun isEmail() {
        print(RegexUtils.isEmail("815786482@qq.com"))
    }

    @Test
    fun isURL() {
        print(RegexUtils.isURL("http://baidu.com"))
    }

    @Test
    fun isZh() {
        print(RegexUtils.isZh("你好"))
    }

    @Test
    fun isDate() {
        print(RegexUtils.isDate("2018-09-12"))
    }
}