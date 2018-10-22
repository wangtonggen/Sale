package com.xindaxin.sale.mvp.presenter

import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.BaseObserver
import com.xindaxin.sale.mvp.base.HttpResponse
import com.xindaxin.sale.mvp.contract.UserContract
import com.xindaxin.sale.mvp.model.UserModel

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：登录的presenter
 */
class LoginPresenterImp(val view: UserContract.LoginView) : UserContract.LoginPresenter {
    private val userModel: UserModel by lazy {
        //当使用的时候在初始化
        UserModel()
    }

    override fun login(params: Map<String, Any>) {
        if (view.checkLoginData()) {
            view.showDialog()
            userModel.login(params, object : BaseObserver<LoginBean>() {
                override fun success(data: HttpResponse<LoginBean>) {
                    view.loginSuccess(data)
                    //保存数据 并跳转界面 感觉还是要放到Activity或者fragment里面实现会更好
                }

                override fun error() {
                    view.cancelDialog()
                }

                override fun complete() {
                    view.cancelDialog()
                }
            })
        }
    }
}
