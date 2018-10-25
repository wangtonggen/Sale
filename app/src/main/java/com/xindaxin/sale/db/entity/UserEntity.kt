package com.xindaxin.sale.db.entity

import org.litepal.annotation.Column
import org.litepal.crud.LitePalSupport

/**
 * author: wtg by 2018/10/25 0025
 *
 *
 * desc: 实体类
 */
class UserEntity : LitePalSupport() {
    var id: Long = 0
    @Column(unique = true)//保存唯一性
    var userId: Long = 0
    var userName: String? = null
    var account: String? = null
    var password: String? = null
    var headImageUrl: String? = null
    var idCard: String? = null
    var birthDay: String? = null
}
