package com.xindaxin.sale.utils

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author: wtg by 2018/9/27 0027
 * @desc:
 */
class TimeUtilsTest {

    @Test
    fun formatTime() {
        var time = TimeUtils.formatTime(Date(),TimeUtils.DEFAULT_FORMAT_NO_SECOND)
        print(time)
//        LogUtils.e("TAG",time)
    }

    @Test
    fun formatTime1() {
//        var time = TimeUtils.formatTime("2018年09月27日 14:07")
        var time = TimeUtils.formatTime("2018年09月27日 14:07",TimeUtils.DEFAULT_FORMAT,"yyyy年MM月dd日 HH:mm")
        print(time)
    }

    @Test
    fun formatTime2() {
    }
}