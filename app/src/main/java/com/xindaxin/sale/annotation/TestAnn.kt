package com.xindaxin.sale.annotation

import android.support.annotation.IntDef

import java.lang.annotation.RetentionPolicy

/**
 * author: wtg by 2018/10/31 0031
 *
 *
 * desc: 以后使用注解的的时候,用java来写,可以限制书写的内容,kotlin注解发现,不在此范围的数字无提醒
 */
@IntDef(Test.ONE, Test.TWO, Test.THREE)
@Retention(AnnotationRetention.SOURCE)
annotation class TestAnn//    int one = Test.ONE;
//    int two = Test.TWO;
//    int three = Test.THREE;
