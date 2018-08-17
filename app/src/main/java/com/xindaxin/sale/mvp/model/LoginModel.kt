package com.xindaxin.sale.mvp.model

import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.BaseObserver
import com.xindaxin.sale.mvp.base.HttpResponse
import com.xindaxin.sale.mvp.base.IBaseRequestCallBack
import com.xindaxin.sale.mvp.base.ServiceFactory
import com.xindaxin.sale.mvp.service.LoginService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：登录的model类,用来进行网络请求
 */
class LoginModel {
    private val loginService: LoginService by lazy {
        //使用懒加载
        ServiceFactory.getInstance().createService(LoginService::class.java)
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param imobile 登录端标识符
     * @param iBaseRequestCallBack 数据返回接口
     */
    fun login(username: String, password: String, imobile: Int, iBaseRequestCallBack: IBaseRequestCallBack<LoginBean>) {
        loginService.login(username, password, imobile)
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
        loginService.register(username, password)
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