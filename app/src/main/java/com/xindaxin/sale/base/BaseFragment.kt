package com.xindaxin.sale.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 创建者：王统根
 * 时间：2018-06-23
 * 描述：fragment的基类
 */
abstract class BaseFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getResView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        onclickListener()
    }

    override fun onClick(p0: View?) {

    }

    /**
     * 获取当前view
     */
    abstract fun getResView(): View

    /**
     * 初始化控件
     */
    abstract fun initView()

    /**
     * 点击事件
     */
    abstract fun onclickListener()
}