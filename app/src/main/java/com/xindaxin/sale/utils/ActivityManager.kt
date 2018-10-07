package com.xindaxin.sale.utils

import android.app.Activity
import android.content.Context
import java.util.*

/**
 * activity的管理类
 */
class ActivityManager private constructor() {
    private val TAG = javaClass.simpleName
    // Activity栈
    private val activityStack: Stack<Activity> = Stack()

    companion object {
        private var mInstance: ActivityManager? = null
        fun getInstance(): ActivityManager {
            if (mInstance == null) {
                synchronized(ActivityManager::class.java) {
                    if (mInstance == null) {
                        mInstance = ActivityManager()
                    }
                }
            }
            return mInstance!!
        }
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) = activityStack.add(activity)


    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity = activityStack.lastElement()


    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishCurrentActivity() = finishActivity(activityStack.lastElement())


    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        if (activity != null) {
            activityStack.remove(activity)
            activity.finish()
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        for (activity in activityStack) {
            if (activity.javaClass == cls) {
                finishActivity(activity)
            }
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        for (i in activityStack.indices) {
            if (null != activityStack[i]) {
                activityStack[i].finish()
            }
        }
        activityStack.clear()
    }

    /**
     * 关闭之前的activity
     */
    fun finishBeforeAllActivity() {
        for (i in 0 until activityStack.size - 1) {
            if (null != activityStack[i]) {
                activityStack[i].finish()
            }
        }
        activityStack.clear()
    }

    /**
     * 退出应用程序
     */
    fun appExit(context: Context) {
        try {
            finishAllActivity()
            val activityMgr = context
                    .getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
            activityMgr.killBackgroundProcesses(context.packageName)
            System.exit(0)
        } catch (e: Exception) {
//            LogUtils.e(TAG, e.message)
            LogUtils.e(TAG, e.message)
        }

    }
}
