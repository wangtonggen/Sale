package com.xindaxin.sale.db

import android.content.ContentValues
import android.content.Context
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select

/**
 * @author: wtg by 2018/9/28 0028
 *
 *
 * @desc:
 *
 **/
@Deprecated("已过时,用liePal代替")
class DBUtils(context: Context, var tableName: String) {
    var dbHelper: DBHelper

    init {
        dbHelper = DBHelper(context)
    }

    fun insertInfo(nullColumnHack: String, values: ContentValues) {
        dbHelper.use {
            insert(tableName, nullColumnHack, values)
        }
    }

    fun delete(whereClause: String, whereArgs: Array<String>) {
        dbHelper.use {
            delete(tableName, whereClause, whereArgs)
        }
    }

    fun selectUser(): List<com.xindaxin.sale.bean.User> {
        var list: List<com.xindaxin.sale.bean.User>? = null
        dbHelper.use {
            list = select(tableName).exec { parseList(classParser()) }
        }
        return list!!
    }
}