package com.xindaxin.sale.mvp.model

import com.xindaxin.sale.mvp.base.ServiceFactory
import com.xindaxin.sale.mvp.service.CommonService

/**
 * author: wtg by 2018/10/19 0019
 *
 *
 * desc: model的基类(采用懒加载)
 * kotlin 泛型和java泛型 kotlin out T 相当于java中的<? extents T> kotlin中的in T 相当于java中的<? super T> kotlin * 相当于Java中的*
 **/
open class BaseModel {
    protected val commonService by lazy { ServiceFactory.getInstance().createService(CommonService::class.java) }
}