package com.xindaxin.sale.ui.activity

import com.xindaxin.sale.R
import com.xindaxin.sale.base.BaseActivity
import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.mvp.base.HttpResponse
import com.xindaxin.sale.mvp.contract.LoginContract
import com.xindaxin.sale.mvp.presenter.LoginPresenterImp
import com.xindaxin.sale.utils.LogUtils
import com.xindaxin.sale.utils.ProgressDialogUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.view_toolbar.*

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：登录界面
 */
class LoginActivity : BaseActivity(), LoginContract.LoginView {
    private lateinit var loginPresenter: LoginPresenterImp
    override fun getResLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        initNoIconToolbar(toolbar1, R.string.title_login)
        initToolbar(toolbar1,R.string.title_login);
        loginPresenter = LoginPresenterImp(this)

//        ThreadPoolUtils.getInstance().execute(Runnable {  })
    }

    override fun onClickListener() {
        btn_login.setOnClickListener { loginPresenter.login(getAccount(), getPassword(), 222777) }
    }

    override fun showDialog() {
        ProgressDialogUtils.showProgress(this, R.string.hint_progress_login)
    }

    override fun cancelDialog() {
        ProgressDialogUtils.hideProgress()
    }

    override fun getAccount(): String {
        return et_account.text.toString().trim()
    }

    override fun getPassword(): String {
        return et_password.text.toString().trim()
    }

    override fun loginSuccess(loginBean: HttpResponse<LoginBean>) {
        LogUtils.e(TAG, loginBean.toString())
    }

}