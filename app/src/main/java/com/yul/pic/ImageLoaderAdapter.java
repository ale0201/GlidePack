package com.yul.pic;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.yul.pic.transform.BlurBitmapTranformation;
import com.yul.pic.transform.GlideCircleTransformation;
import com.yul.pic.transform.RoundBitmapTranformation;

/**
 * 适配器
 */
public class ImageLoaderAdapter implements ImageLoaderListener {

    @Override
    public void init(Context context) {

    }

    @Override
    public void destroy(Context context) {

    }

    @Override
    public void displayBlurImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes, int blurRadius) {
        Glide.with(context).load(url).diskCacheStrategy(diskCacheStrategy).apply(blurRequestOptions(placeRes, errorRes, blurRadius)).into(imageView);
    }

    @Override
    public void displayBlurImage(Context context, int resId, ImageView imageView, int blurRadius) {
        Glide.with(context).load(resId).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).apply(blurRequestOptions(resId, resId, blurRadius)).into(imageView);
    }

    @Override
    public void displayCircleImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes) {
        Glide.with(context).load(url).diskCacheStrategy(diskCacheStrategy).apply(circleRequestOptions(placeRes, errorRes)).into(imageView);
    }

    @Override
    public void displayRoundImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes, int radius) {
        Glide.with(context).load(url).diskCacheStrategy(diskCacheStrategy).apply(roundRequestOptions(placeRes, errorRes, radius)).into(imageView);
    }

    @Override
    public void displayCircleImage(Context context, int resId, ImageView imageView) {
        Glide.with(context).load(resId).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).apply(circleRequestOptions(resId, resId)).into(imageView);
    }

    @Override
    public void displayRoundImage(Context context, int resId, ImageView imageView, int radius) {
        Glide.with(context).load(resId).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).apply(roundRequestOptions(resId, resId, radius)).into(imageView);
    }

    /**
     * 获取展位图以及加载失败图
     * @param placeholderResId
     * @param errorResId
     * @return
     */
    public RequestOptions requestOptions(int placeholderResId, int errorResId) {
        return new RequestOptions().placeholder(placeholderResId).error(errorResId);
    }

    /**
     * 获取自定义边框属性配置
     * @param placeholderResId
     * @param errorResId
     * @param bitmapTransformation
     * @return
     */
    public RequestOptions requestOptionsTransformation(int placeholderResId, int errorResId, BitmapTransformation bitmapTransformation) {
        return requestOptions(placeholderResId, errorResId).transform(bitmapTransformation);
    }

    /**
     * 获取圆形边框属性
     * @param placeholderResId
     * @param errorResId
     * @return
     */
    public RequestOptions circleRequestOptions(int placeholderResId, int errorResId) {
        return requestOptions(placeholderResId, errorResId).transform(new GlideCircleTransformation());
    }

    /**
     * 实现自定义角度边框属性
     * @param placeholderResId
     * @param errorResId
     * @param radius
     * @return
     */
    public RequestOptions roundRequestOptions(int placeholderResId, int errorResId,int radius) {
        return requestOptions(placeholderResId, errorResId).transform(new RoundBitmapTranformation(radius));
    }

    /**
     * 获取高斯模糊属性
     * @param placeResId
     * @param errorResId
     * @param blurRadius
     * @return
     */
    private RequestOptions blurRequestOptions(int placeResId, int errorResId, int blurRadius) {
        return requestOptions(placeResId, errorResId).transform(new BlurBitmapTranformation(blurRadius));
    }

}
