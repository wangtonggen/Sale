package com.xindaxin.sale.mvp.base

import io.reactivex.Observable

/**
 * @author: wtg by 2018/9/30 0030
 *
 *
 * @desc:  对Observable进行统一设置
 *
 **/
abstract class BaseObservable<T> : Observable<HttpResponse<T>> {
    constructor() : super()
}