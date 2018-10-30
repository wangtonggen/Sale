package com.xindaxin.sale.ui.activity

import android.graphics.drawable.Drawable
import android.os.Handler
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.xindaxin.sale.R
import com.xindaxin.sale.annotation.*
import com.xindaxin.sale.annotation.Week
import com.xindaxin.sale.base.BaseActivity
import com.xindaxin.sale.bean.LoginBean
import com.xindaxin.sale.db.entity.UserEntity
import com.xindaxin.sale.mvp.base.HttpResponse
import com.xindaxin.sale.mvp.contract.UserContract
import com.xindaxin.sale.mvp.presenter.LoginPresenterImp
import com.xindaxin.sale.utils.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.view_toolbar.*
import org.jetbrains.anko.toast
import org.litepal.LitePal
import org.litepal.extension.findAll

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：登录界面
 */
class LoginActivity : BaseActivity(), UserContract.LoginView {
    private lateinit var loginPresenter: LoginPresenterImp
    private var list = listOf("111", "222", "333", "444")

    @Week.WeekDays
    private var currentDay = TIP_A

    override fun getResLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        initNoIconToolbar(toolbar1, R.string.title_login)
        loginPresenter = LoginPresenterImp(this)
//        val test = "i am li"
        list.forEach { tv_test.text = String.format("%s", it) }
        tv_test.text = "${R.string.app_name}"
        setCurrentDay(1)
        @Week.WeekDays
        val today = getCurrentDay()
        when (today) {
            TIP_A -> {
                toast("$TIP_A")
            }
            TIP_B -> {
                toast("$TIP_B")
            }
            TIP_C -> {
                toast("$TIP_C")
            }
        }

//        val userEntity = UserEntity()
//        userEntity.userId = 0
//        userEntity.userName="王统根"
//        userEntity.account="15727960191"
//        userEntity.password="123456"
//        userEntity.headImageUrl="http://192.168.2.23/image"
//        userEntity.idCard = "412326199806186033"
//        userEntity.birthDay = "1992-04-08"
//        val result = userEntity.save()
//        LogUtils.e(TAG,result)
//        val orderEntity = OrderEntity()
//        orderEntity.orderId = 0
//        orderEntity.title = "呵呵"
//        var result1 = orderEntity.save()
//        LogUtils.e(TAG,result1)
//        val users = LitePal.findAll<UserEntity>()
//        users.forEach { LogUtils.e(TAG,"userId=${it.userId}") }
//        val orders = LitePal.findAll(OrderEntity::class.java)
//        orders.forEach { LogUtils.e(TAG,"orderId=${it.orderId}") }
//        et_account.setText("$test")//给editText 赋值时要使用setText方法
//        et_account.text ="hello"

//        LogUtils.e(TAG,list.count())
//        LogUtils.e(TAG,list.size)
//        LogUtils.e(TAG,list.filter { it.length > 1 })
//        list.filter { it.startsWith("w") }
//        var dbUserUtils = DBUserUtils(this,User.TABLE_NAME)
//        dbUserUtils.delete()
//        ThreadPoolUtils.getInstance().execute(Runnable {  })

//        val imageView = ImageView(this)
//        imageView.load("")
//        Glide.with(this).load(R.mipmap.a).listener(object : RequestListener<Drawable>{
//            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
//                return false
//            }
//
//            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
//                when(resource){
//                    is GifDrawable -> resource.setLoopCount(1)
//                }
//                return false
//            }
//        }).into(a)
//        Glide.with(this).load(R.mipmap.b).listener(object : RequestListener<Drawable>{
//            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
//                return false
//            }
//
//            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
//                when(resource){
//                    is GifDrawable -> resource.setLoopCount(1)
//                }
//                return false
//            }
//        }).into(b)
    }

    override fun onClickListener() {
        btn_login.setOnClickListener {
            btn_login.isEnabled = false
//            loginPresenter.login(getAccount(), getPassword(), 222777)
//            showDialog()
//            Handler().postAtTime({
//                cancelDialog()
//                startActivity(Intent(this@LoginActivity,MainActivity::class.java))},2000)
//            TimeUtils.countDown(1,20,object : DefaultObserver<Long>() {
//                override fun onComplete() {
//                    btn_login.text = "登录"
//                    btn_login.isEnabled = true
//                    cancel()
//                }
//
//                override fun onNext(t: Long) {
//                    btn_login.text = String.format("%s s后重新登录",t)
//                    LogUtils.e("countDown", "$t")
//                }
//
//                override fun onError(e: Throwable) {
//                    btn_login.isEnabled = true
//                    cancel()
//                }
//            })
//            TimeUtils.timer(1,object : DefaultObserver<Long>() {
//                override fun onComplete() {
//                    btn_login.text = "登录"
//                    btn_login.isEnabled = true
//                    cancel()
//                }
//
//                override fun onNext(t: Long) {
//                    btn_login.text = String.format("%s s后重新登录",t)
//                    LogUtils.e("countDown", "$t")
//                }
//
//                override fun onError(e: Throwable) {
//                    btn_login.isEnabled = true
//                    cancel()
//                }
//            })
        }
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
        toast(loginBean.msg)
        Handler().postAtTime({ print("hahaaha") }, 2000)
    }

    override fun checkLoginData(): Boolean {
        if (TextUtils.isEmpty(getAccount())) {
            ToastUtils.showShortToast("账号不能为空")
            return false
        }

        if (TextUtils.isEmpty(getPassword())) {
            ToastUtils.showShortToast("密码不能为空")
            return false
        }
        return true
    }

    /**
     * 参数只能传入在声明范围内的整型，不然编译通不过
     * @param currentDay
     */
    private fun setCurrentDay(@Week.WeekDays currentDay: Int) {
        this.currentDay = currentDay
    }

    @Week.WeekDays
    fun getCurrentDay(): Int {
        return currentDay
    }

}