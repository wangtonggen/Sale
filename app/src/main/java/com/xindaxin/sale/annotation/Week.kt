package com.xindaxin.sale.annotation

import android.support.annotation.IntDef

/**
 * author: wtg by 2018/10/19 0019
 *
 *
 * desc:
 *
 **/
const val TIP_A = 1
const val TIP_B = 2
const val TIP_C = 3
const val TIP_D = 4
interface Week {
    @IntDef(TIP_A, TIP_B, TIP_C)
    @Retention(AnnotationRetention.SOURCE)
    annotation class WeekDays
}