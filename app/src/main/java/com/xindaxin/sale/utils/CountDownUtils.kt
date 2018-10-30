package com.xindaxin.sale.utils

import android.os.CountDownTimer

/**
 * author: wtg by 2018/10/24 0024
 *
 * desc: 类似于秒杀倒计时
 *
 **/
class CountDownUtils {
    private var mTimer: CountDownTimer? = null
    private val mInterval = 1000

    /**
     * 开始倒计时
     *
     * @param startTime      开始时间（时间戳）
     * @param minuteInterval 时间间隔（单位：分）
     * @param callBack
     */
    @JvmOverloads
    fun start(startTime: Long, minuteInterval: Int, callBack: OnCountDownCallBack?, interval: Int = mInterval) {
        val lengthTime = (minuteInterval * 60 * interval).toLong()
        //查看是否为毫秒的时间戳
        val isMillSecond = startTime.toString().length == 13
        val startTime1 = startTime * if (isMillSecond) 1 else interval
        val endTime = startTime1 + lengthTime
        val curTime = System.currentTimeMillis()
        mTimer = getTimer(endTime - curTime, interval.toLong(), callBack)
        if (Math.abs(curTime - startTime1) > lengthTime) {
            callBack?.onFinish()
        } else {
            mTimer!!.start()
        }
    }

    /**
     * 开始倒计时 根据服务器的时间来计算倒计时
     *
     * @param startTime 开始时间（时间戳）
     * @param endTime   结束时的时间戳
     * @param callBack
     */
    @JvmOverloads
    fun start(startTime: Long, endTime: Long, callBack: OnCountDownCallBack?, interval: Int = mInterval) {
        //查看是否为毫秒的时间戳
        val isMillSecond = startTime.toString().length == 13
        val isMillSecond1 = endTime.toString().length == 13
        val startTime1 = startTime * if (isMillSecond) 1 else interval
        val endTime1 = endTime * if (isMillSecond1) 1 else interval
        if (endTime1 < startTime1) {
            callBack?.onFinish()
        } else {
            mTimer!!.start()
        }
    }

    /**
     * 开始倒计时
     *
     * @param endTime  结束时间（时间戳秒级别）需要转换成毫秒级别*1000
     * @param callBack
     */
    @JvmOverloads
    fun start(endTime: Long, callBack: OnCountDownCallBack?, interval: Int = mInterval) {
        val curTime = System.currentTimeMillis()
        val isMillSecond = endTime.toString().length == 13
        val endTime1 = endTime * if (isMillSecond) 1 else interval
        mTimer = getTimer(endTime1 - curTime, interval.toLong(), callBack)
        if (endTime1 < curTime) {
            callBack?.onFinish()
        } else {
            mTimer!!.start()
        }
    }

    /**
     * 监听倒计时时间
     * @param millisInFuture Long
     * @param interval Long
     * @param callBack OnCountDownCallBack?
     * @return CountDownTimer
     */
    private fun getTimer(millisInFuture: Long, interval: Long, callBack: OnCountDownCallBack?): CountDownTimer {
        return object : CountDownTimer(millisInFuture, interval) {
            override fun onTick(millisUntilFinished: Long) {
                var day = 0
                var hour = 0
                var minute = (millisUntilFinished / interval / 60).toInt()
                val second = (millisUntilFinished / interval % 60).toInt()
                if (minute >= 60) {
                    hour = minute / 60
                    minute %= 60
                }
                if (hour >= 24) {
                    day = hour / 24
                    hour %= 24
                }
                callBack?.onProcess(day, hour, minute, second)
            }

            override fun onFinish() {
                callBack?.onFinish()
            }
        }
    }

    /**
     * 必用
     */
    fun onDestroy() {
        mTimer!!.cancel()
        mTimer = null
    }

    interface OnCountDownCallBack {

        fun onProcess(day: Int, hour: Int, minute: Int, second: Int)

        fun onFinish()
    }
}