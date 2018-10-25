package com.xindaxin.sale.db.entity

import org.litepal.annotation.Column
import org.litepal.crud.LitePalSupport

/**
 * author: wtg by 2018/10/25 0025
 *
 * desc:
 *
 **/
class OrderEntity : LitePalSupport() {
    var orderId: Long = 0
    @Column(unique = true)//保持唯一性
    var id: Long = 0
    var title: String? = null

}