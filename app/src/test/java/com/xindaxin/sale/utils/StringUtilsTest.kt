package com.xindaxin.sale.utils

import com.xindaxin.sale.R
import org.junit.Test

import org.junit.Assert.*

/**
 * @author: wtg by 2018/9/27 0027
 * @desc:
 */
class StringUtilsTest {

    @Test
    fun getString() {
        print(StringUtils.getString(R.string.title_login))
    }

    @Test
    fun getEncodeMobile() {
        print(StringUtils.getEncodeMobile("15727960191"))
    }

    @Test
    fun stringFormat() {
        print(StringUtils.stringFormat("时间是:",TimeUtils.formatTime("199005141445",TimeUtils.DEFAULT_FORMAT,"yyyyMMddHHmm")))
    }
}