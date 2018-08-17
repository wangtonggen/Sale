package com.xindaxin.sale.mvp.presenter

import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.HttpResponse
import com.xindaxin.sale.mvp.base.IBaseRequestCallBack
import com.xindaxin.sale.mvp.contract.LoginContract
import com.xindaxin.sale.mvp.model.LoginModel

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：登录的presenter
 */
class LoginPresenterImp(val view: LoginContract.LoginView) : LoginContract.LoginPresenter {
    private val loginModel: LoginModel by lazy {
        LoginModel()
    }

    override fun login(account: String, password: String, imobile: Int) {
        view.showDialog()
        loginModel.login(account, password, imobile, object : IBaseRequestCallBack<LoginBean> {
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

    override fun checkData(): Boolean {
        return true
    }
}
