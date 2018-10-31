package com.xindaxin.sale.utils

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.annotation.StyleRes
import android.view.Gravity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.PopupWindow
import com.xindaxin.sale.R

/**
 * author: wtg by 2018/10/31 0031
 *
 * desc: 关于pop相关
 *
 **/
object PopUtils {
    /**
     * 在控件上面显示pop
     * @param contentView View
     * @param context Activity
     * @param parent View
     * @return PopupWindow
     */
    @JvmOverloads
    fun showUpPop(context: Activity, contentView: View, parent: View = context.window.decorView): PopupWindow {
        val pop = PopupWindow(contentView, -1, -2)
        pop.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        pop.isOutsideTouchable = true
        pop.isOutsideTouchable = true
        pop.isFocusable = true
        val lp = context.window.attributes
        lp.alpha = 0.5f
        context.window.attributes = lp
        pop.setOnDismissListener {
            val lp1 = context.window.attributes
            lp1.alpha = 1f
            context.window.attributes = lp1
        }
        pop.animationStyle = R.style.pop_bottom_to_up_style
        pop.showAtLocation(parent, Gravity.BOTTOM, 0, 0)
        return pop
    }

    /**
     * 在控件下面显示 其他区域颜色不变,通过添加遮罩层改变其他区域颜色为暗色
     * @param context Activity
     * @param contentView View
     * @param backgroundView 遮罩层(用来改变指定区域的明暗程度)
     * @param parent View
     * @return PopupWindow
     */
    @JvmOverloads
    fun showDownPop(context: Activity, contentView: View, backgroundView: View, parent: View = context.window.decorView): PopupWindow {
        val pop = PopupWindow(contentView, -1, -2)
        pop.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        pop.isOutsideTouchable = true
        pop.isOutsideTouchable = true
        pop.isFocusable = true
        pop.setOnDismissListener {
            backgroundView.visibility = GONE
//            pop.contentView.startAnimation(AnimationUtils.createOutAnimation(context, -fromYDelta))
        }
        pop.animationStyle = R.style.pop_vertical_style
        pop.showAsDropDown(parent, 0, 0)
//        pop.showAtLocation(parent,Gravity.NO_GRAVITY,0,0)
        backgroundView.visibility = VISIBLE
//        pop.contentView.startAnimation(AnimationUtils.createInAnimation(context, fromYDelta))
        return pop
    }

    /**
     * 关闭pop
     * @param pop PopupWindow?
     */
    private fun closePopupWindow(pop: PopupWindow?) {
        if (pop != null && pop.isShowing) {
            pop.dismiss()
        }
    }
}