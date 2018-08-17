package com.xindaxin.sale.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xindaxin.sale.bean.LoginBean

/**
 * 创建者：王统根
 * 时间：2018-07-17
 * 描述：测试adapter
 */
class TestAdapter : BaseQuickAdapter<LoginBean, BaseViewHolder> {
    constructor(layoutResId: Int, data: MutableList<LoginBean>?) : super(layoutResId, data)

    override fun convert(helper: BaseViewHolder, item: LoginBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}