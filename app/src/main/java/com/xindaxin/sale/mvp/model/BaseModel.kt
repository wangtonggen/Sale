package com.xindaxin.sale.mvp.model

import com.xindaxin.sale.mvp.base.ServiceFactory
import com.xindaxin.sale.mvp.service.CommonService

/**
 * author: wtg by 2018/10/19 0019
 *
 *
 * desc:
 *
 **/
open class BaseModel {
    protected val commonService by lazy { ServiceFactory.getInstance().createService(CommonService::class.java) }
}