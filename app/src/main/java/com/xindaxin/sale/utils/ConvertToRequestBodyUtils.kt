package com.xindaxin.sale.utils

import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * author: wtg by 2018/10/31 0031
 *
 * desc: 把string转换成 requestBody
 *
 **/
object ConvertToRequestBodyUtils {
    /**
     * 把string转换成 requestBody
     * @param param String
     * @return RequestBody
     */
    fun convertToRequestBody(param: String): RequestBody {
        return RequestBody.create(MediaType.parse("text/plain"), param)
    }
}