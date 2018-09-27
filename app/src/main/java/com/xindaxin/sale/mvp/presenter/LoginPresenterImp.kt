package com.xindaxin.sale.mvp.presenter

import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.HttpResponse
import com.xindaxin.sale.mvp.base.IBaseRequestCallBack
import com.xindaxin.sale.mvp.contract.LoginContract
import com.xindaxin.sale.mvp.model.UserModel

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：登录的presenter
 */
class LoginPresenterImp(val view: LoginContract.LoginView) : LoginContract.LoginPresenter {
    private val userModel: UserModel by lazy {//当使用的时候在初始化
        UserModel()
    }

    override fun login(account: String, password: String, imobile: Int) {
        view.showDialog()
        userModel.login(account, password, imobile, object : IBaseRequestCallBack<LoginBean> {
            override fun requestSuccess(data: HttpResponse<LoginBean>) {
                view.loginSuccess(data)
            }

            override fun requestError() {
                view.cancelDialog()
            }

            override fun requestComplete() {
                view.cancelDialog()
            }
        })
    }
}
