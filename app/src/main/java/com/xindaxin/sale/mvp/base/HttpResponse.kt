package com.xindaxin.sale.mvp.base

import java.io.Serializable

/**
 *  通用的bean,数据统一标准
 */
data class HttpResponse<T>(var success: Boolean, var msg: String, var obj: T) : Serializable
