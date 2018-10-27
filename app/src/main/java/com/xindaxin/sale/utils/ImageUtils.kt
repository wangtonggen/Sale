package com.xindaxin.sale.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.xindaxin.sale.R
import com.bumptech.glide.request.RequestOptions


/**
 * author: wtg by 2018/10/26 0026
 *
 * desc:  全局文件 扩展函数加载图片的使用
 *
 **/

/**
 * 普通加载图片
 * @receiver ImageView
 * @param url String?
 */
fun ImageView.load(url: String?) {
    get(url).apply(RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher_round)).into(this)
}

/**
 * 占位符圆角矩形
 * @receiver ImageView
 * @param url String?
 * @param roundedCorners Int 圆角大小
 */
fun ImageView.loadRound(url: String?, roundedCorners: Int) {
    //设置图片圆角角度
    get(url).apply(RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher_round).transform(RoundedCorners(roundedCorners))).into(this)
}

/**
 * 占位符圆形
 * @receiver ImageView
 * @param url Drawable? Drawable
 */
fun ImageView.loadCircle(url: Drawable?) {
    get(url).apply(RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher_round).circleCrop().autoClone()).into(this)
}

/**
 * 占位符圆形
 * @receiver ImageView
 * @param url String? url
 */
fun ImageView.loadCircle(url: String?) {
    get(url).apply(RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher_round).circleCrop().autoClone()).into(this)
}

/**
 * 占位符圆形
 * @receiver ImageView
 * @param url Int url 资源文件
 */
fun ImageView.loadCircle(url: Int) {
    get(url).apply(RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher_round).circleCrop().autoClone()).into(this)
}

fun ImageView.get(url: String?): RequestBuilder<Drawable> = Glide.with(context).load(url)
fun ImageView.get(url: Drawable?): RequestBuilder<Drawable> = Glide.with(context).load(url)
fun ImageView.get(resId: Int): RequestBuilder<Drawable> = Glide.with(context).load(resId)