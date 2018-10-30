package com.xindaxin.sale.mvp.model

import com.xindaxin.sale.API.API
import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.BaseObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author: wtg by 2018/9/27 0027
 *
 *
 * @desc: 用户的数据处理类
 *
 **/
class UserModel : BaseModel() {
//    private val userService: UserService by lazy { ServiceFactory.getInstance().createService(UserService::class.java) }
    /**
     * 登录
     * @param params 参数集合
     * @param observer 数据返回接口
     */
    fun login(params: Map<String, Any>, observer: BaseObserver<LoginBean>) {
        commonService.requestPost<LoginBean>(API.URL_LOGIN, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    /**
     * 注册
     * @param params Map<String, Any>
     * @param observer BaseObserver<String>
     */
    fun register(params: Map<String, Any>, observer: BaseObserver<String>) {
        commonService.requestPost<String>(API.URL_REGISTER, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }
}