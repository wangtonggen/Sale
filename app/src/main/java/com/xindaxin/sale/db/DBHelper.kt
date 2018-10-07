package com.xindaxin.sale.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * @author: wtg by 2018/9/8 0008
 * @desc: 数据库操作类
 */
class DBHelper(context: Context) : ManagedSQLiteOpenHelper(context, DB_NAME, null, DATABASE_VERSION) {
    companion object {
        private val DB_NAME = "sale.db"//数据库的名字
        private val DATABASE_VERSION = 1

        private var instance: DBHelper? = null
        @Synchronized
        fun instance(context: Context): DBHelper {
            if (instance == null) {
                instance = DBHelper(context.applicationContext)
            }
            return instance!!
        }
    }

    val Context.database: DBHelper
        get() = DBHelper.instance(applicationContext)

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.createTable(User.TABLE_NAME, true, User._ID to TEXT + PRIMARY_KEY, User.ID to TEXT, User.TOKEN to TEXT, User.NAME to TEXT, User.ACCOUNT to TEXT, User.PASSWORD to TEXT)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.dropTable(User.TABLE_NAME, true)
    }
}
