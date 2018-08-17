package com.xindaxin.sale.utils

import android.content.Context
import android.content.SharedPreferences

import com.xindaxin.sale.base.BaseApplication

/**
 * Created by 王统根
 * Date 16/6/27
 * Desc sp的保存和取值
 */
object SPUtils {
    private val SP_NAME = "sale"
    private var preferences: SharedPreferences? = null

    private fun instance(name: String) {
        if (preferences == null) {
            preferences = BaseApplication.instance.getSharedPreferences(name, Context.MODE_PRIVATE)
        }
    }

    /**
     * 获取指定key的值
     *
     * @param name
     * @param key
     * @return
     */
    fun getString(name: String, key: String): String? {
        instance(name)
        return preferences!!.getString(key, null)
    }

    /**
     * 设置指定spname,key的和value
     *
     * @param name
     * @param key
     * @param value
     */
    fun setString(name: String, key: String, value: String) {
        instance(name)
        val editor = preferences!!.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getInteger(name: String, key: String): Int {
        instance(name)
        return preferences!!.getInt(key, -1)
    }

    fun setInteger(name: String, key: String, value: Int) {
        instance(name)
        val editor = preferences!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    /**
     * 获取Boolean
     *
     * @param name
     * @param key
     * @return
     */
    fun getBoolean(name: String, key: String): Boolean {
        instance(name)
        return preferences!!.getBoolean(key, false)
    }

    /**
     * 保存boolean
     *
     * @param name
     * @param key
     * @param value
     */
    fun setBoolean(name: String, key: String, value: Boolean) {
        instance(name)
        val editor = preferences!!.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getString(key: String): String? {
        return getString(SP_NAME, key)
    }

    fun setString(key: String, value: String) {
        setString(SP_NAME, key, value)
    }

    fun getInteger(key: String): Int {
        return getInteger(SP_NAME, key)
    }

    fun setInteger(key: String, value: Int) {
        setInteger(SP_NAME, key, value)
    }

    fun getBoolean(key: String): Boolean {
        return getBoolean(SP_NAME, key)
    }

    fun setBoolean(key: String, value: Boolean) {
        setBoolean(SP_NAME, key, value)
    }

    /**
     * 清空sp
     */
    fun clearSharePreferences() {
        val editor = preferences!!.edit()
        editor.clear()
        editor.apply()
    }
}
