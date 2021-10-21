package com.yul.pic;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 适配器接口（可添加自定义接口实现）
 */
public interface ImageLoaderListener {
    // 初始化glide
    void init(Context context);
    // 销毁
    void destroy(Context context);

    // 展示网络模糊图片
    void displayBlurImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes, int blurRadius);
    // 展示本地模糊图片
    void displayBlurImage(Context context, int resId, ImageView imageView, int blurRadius);
    // 展示网络圆形图片
    void displayCircleImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes);
    // 展示网络自定义角度图片
    void displayRoundImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes, int radius);
    // 展示本地圆形图片
    void displayCircleImage(Context context, int resId, ImageView imageView);
    // 展示本地自定义角度图片
    void displayRoundImage(Context context, int resId, ImageView imageView, int radius);
}
