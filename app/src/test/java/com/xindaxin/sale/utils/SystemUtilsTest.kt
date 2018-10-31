package com.xindaxin.sale.utils

import org.junit.Test

import org.junit.Assert.*

/**
 * author: wtg by 2018/10/30 0030
 *
 *
 * desc:
 */
class SystemUtilsTest {

    @Test
    fun dialPhone() {
        SystemUtils.dialPhone("")
    }

    @Test
    fun callPhone() {
        SystemUtils.dialPhone("")
    }

    @Test
    fun getVersionCode() {
        println(SystemUtils.getVersionCode())
//        LogUtils.e("tag",SystemUtils.getVersionCode())
    }

    @Test
    fun getVersionName() {
        println(SystemUtils.getVersionName())
//        LogUtils.e("tag",SystemUtils.getVersionName())
    }

    @Test
    fun getAPPName() {
        println(SystemUtils.getAPPName())
    }

    @Test
    fun getRandomNumber() {
        println(SystemUtils.getRandomNumber())
    }
}