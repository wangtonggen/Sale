package com.xindaxin.sale.mvp.model

import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.BaseObserver
import com.xindaxin.sale.mvp.base.HttpResponse
import com.xindaxin.sale.mvp.base.IBaseRequestCallBack
import com.xindaxin.sale.mvp.base.ServiceFactory
import com.xindaxin.sale.mvp.service.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rx.Observable

/**
 * @author: wtg by 2018/9/27 0027
 *
 *
 * @desc: 用户的数据处理类
 *
 **/
class UserModel {
    private val userService: UserService by lazy { ServiceFactory.getInstance().createService(UserService::class.java) }
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param imobile 登录端标识符
     * @param iBaseRequestCallBack 数据返回接口
     */
    fun login(username: String, password: String, imobile: Int, iBaseRequestCallBack: IBaseRequestCallBack<LoginBean>) {
        userService.login(username, password, imobile)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<LoginBean>() {
                    override fun success(data: HttpResponse<LoginBean>) {
                        iBaseRequestCallBack.requestSuccess(data)
                    }

                    override fun error() {
                        iBaseRequestCallBack.requestError()
                    }

                    override fun complete() {
                        iBaseRequestCallBack.requestComplete()
                    }
                }

                )

    }

    /**
     * 注册
     */
    fun register(username: String, password: String, iBaseRequestCallBack: IBaseRequestCallBack<String>) {
        userService.register(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<String>() {
                    override fun success(data: HttpResponse<String>) {
                        iBaseRequestCallBack.requestSuccess(data)
                    }

                    override fun error() {
                        iBaseRequestCallBack.requestError()
                    }

                    override fun complete() {
                        iBaseRequestCallBack.requestComplete()
                    }
                })
    }
}