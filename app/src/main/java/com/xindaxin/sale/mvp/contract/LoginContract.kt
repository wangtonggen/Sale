package com.xindaxin.sale.mvp.contract

import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.HttpResponse
import com.xindaxin.sale.mvp.base.IBasePresenter
import com.xindaxin.sale.mvp.base.IBaseDialogView

/**
 * 创建者：王统根
 * 时间：2018-07-23
 * 描述：登录的契约类
 */
open class LoginContract {

    interface LoginPresenter : IBasePresenter {

        /**
         * 登录操作
         * @param account 用户名
         * @param password 密码
         * @param imobile 登录标识
         */
        fun login(account: String, password: String, imobile: Int)

        /**
         * 验证数据
         */
        fun checkData(): Boolean
    }

    interface LoginView : IBaseDialogView {

        /**
         * 获取账号
         */
        fun getAccount(): String

        /**
         * 获取密码
         */
        fun getPassword(): String

        /**
         * 登录数据获取
         */
        fun loginSuccess(loginBean: HttpResponse<LoginBean>)
    }
}