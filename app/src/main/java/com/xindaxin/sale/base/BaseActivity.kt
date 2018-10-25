package com.xindaxin.sale.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import com.xindaxin.sale.R
import com.xindaxin.sale.utils.ActivityManager
import com.xindaxin.sale.utils.StringUtils

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：activity的基类
 */
abstract class BaseActivity : AppCompatActivity() {
    protected val TAG: String = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResLayoutId())
        initView()
        onClickListener()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        ActivityManager.getInstance().addActivity(this)
    }

    /**
     * 初始化箭头toolbar
     * @param toolbar
     * @param titleResId 标题的资源id
     */
    fun initToolbar(toolbar: Toolbar, titleResId: Int) {
        toolbar.title = StringUtils.getString(titleResId)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }

    /**
     * 返回键变成X号
     *
     * @param toolbar
     * @param titleResId 标题的资源id
     */
    protected fun initDeleteToolbar(toolbar: Toolbar, titleResId: Int) {
        initToolbar(toolbar, titleResId, R.drawable.ic_close_white)
    }

    /**
     * 通用toolbar
     *
     * @param toolbar
     * @param titleResId 标题的资源id
     * @param iconResId 导航图标的资源id
     */
    private fun initToolbar(toolbar: Toolbar, titleResId: Int, iconResId: Int) {
        toolbar.title = StringUtils.getString(titleResId)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(iconResId)
        toolbar.setNavigationOnClickListener { finish() }
    }

    /**
     * 没有返回按钮的toolbar
     *
     * @param toolbar
     * @param titleResId 标题的资源id
     */
    protected fun initNoIconToolbar(toolbar: Toolbar, titleResId: Int) {
        toolbar.title = StringUtils.getString(titleResId)
        setSupportActionBar(toolbar)
        toolbar.navigationIcon = null
    }


    /**
     * 获取视图id
     */
    abstract fun getResLayoutId(): Int

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 点击监听事件
     */
    abstract fun onClickListener()
}