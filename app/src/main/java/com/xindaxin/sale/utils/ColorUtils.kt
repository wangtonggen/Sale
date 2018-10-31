package com.xindaxin.sale.utils

import android.graphics.Color
import android.support.annotation.ColorRes
import com.xindaxin.sale.base.BaseApplication

/**
 * author: wtg by 2018/10/31 0031
 *
 * desc: 颜色的工具类
 *
 **/
object ColorUtils {
    /**
     * 颜色值String 转换成Int
     * @param color String
     * @return Int
     */
    fun string2IntColor(color:String):Int{
        return Color.parseColor(color)
    }

    /**
     * 把color的资源id转换成Int
     * @param resId Int
     * @return Int
     */
    fun getIntColor(@ColorRes resId:Int):Int{
        return BaseApplication.instance.resources.getColor(resId)
    }
}