package com.xindaxin.sale.mvp.base

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.xindaxin.sale.BuildConfig
import com.xindaxin.sale.base.BaseApplication
import com.xindaxin.sale.utils.LogUtils
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 创建者：王统根
 * 时间：2018-05-21
 * 描述：创建service的工厂(单利模式)
 */
class ServiceFactory private constructor() {
    //默认超时时间
    private val defaultTimeout: Long = 30
    //okHttp client
    private var httpClientBuilder: OkHttpClient.Builder? = null
    //retrofit
    private var retrofit: Retrofit? = null
    //TAG
    private val TAG = javaClass.simpleName

    companion object {
        private var mInstance: ServiceFactory? = null
        fun getInstance(): ServiceFactory {
            if (mInstance == null) {
                synchronized(ServiceFactory::class.java) {
                    if (mInstance == null) {
                        mInstance = ServiceFactory()
                    }
                }
            }
            return mInstance!!
        }
    }

    /**
     * 创建service
     */
    fun <S> createService(serviceClass: Class<S>): S {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.HOST)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
        return retrofit!!.create(serviceClass)
    }

    /**
     * 获取httpClient的方法
     */
    private fun getOkHttpClient(): OkHttpClient {
        //新建log拦截器
        val loggingInterceptor = HttpLoggingInterceptor { message: String -> LogUtils.e(TAG, "OkHttp====Message:$message") }
        loggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE//设置日志显示级别
        val cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(BaseApplication.instance))
        if (httpClientBuilder == null) {
            //添加cookie
            httpClientBuilder = OkHttpClient.Builder().cookieJar(cookieJar)
            httpClientBuilder!!.connectionPool(ConnectionPool(20, 5, TimeUnit.MINUTES))
            //设置超时时间
            httpClientBuilder!!.connectTimeout(defaultTimeout, TimeUnit.SECONDS)
            httpClientBuilder!!.writeTimeout(defaultTimeout, TimeUnit.SECONDS)
            httpClientBuilder!!.readTimeout(defaultTimeout, TimeUnit.SECONDS)

            httpClientBuilder!!.addInterceptor(loggingInterceptor)
        }
        return httpClientBuilder!!.build()
    }

}