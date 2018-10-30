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
open class UserContract {

    /**
     * 登录相关
     */
    interface LoginPresenter : IBasePresenter {

        /**
         * 登录操作
         * @param params 参数
         */
        fun login(params: Map<String, Any>)
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

        /**
         * 验证登录数据的正确性
         * @return Boolean
         */
        fun checkLoginData(): Boolean
    }

    //注册相关

    interface RegisterPresenter : IBasePresenter {
        /**
         * 全部使用map 特殊情况下,特殊处理
         * @param params Map<String,String>
         */
        fun register(params: Map<String, String>)
    }

    interface RegisterView : IBaseDialogView {
        fun getAccount(): String
        fun getPassword(): String
    }

    //修改信息相关
}