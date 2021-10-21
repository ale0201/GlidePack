package com.yul.pic;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * glide封装处理图片方法
 */
public class GlidePackLoader {
    private volatile static GlidePackLoader instance;
    private static ImageLoaderListener adapter;

    private GlidePackLoader() {
        adapter = new ImageLoaderAdapter();
    }

    public static GlidePackLoader getInstance() {
        if (instance == null) {
            synchronized (GlidePackLoader.class) {
                if (instance == null) {
                    instance = new GlidePackLoader();
                }
            }
        }
        return instance;
    }

    public static void displayBlurImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes, int blurRadius) {
        adapter.displayBlurImage(context, url, imageView, diskCacheStrategy, placeRes, errorRes, blurRadius);
    }

    public static void displayBlurImage(Context context, int resId, ImageView imageView, int blurRadius) {
        adapter.displayBlurImage(context, resId, imageView, blurRadius);
    }

    public void displayCircleImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes) {
        adapter.displayCircleImage(context, url, imageView, diskCacheStrategy, placeRes, errorRes);
    }

    public void displayRoundImage(Context context, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy, int placeRes, int errorRes, int radius) {
        adapter.displayRoundImage(context, url, imageView, diskCacheStrategy, placeRes, errorRes, radius);
    }

    public void displayCircleImage(Context context, int resId, ImageView imageView) {
        adapter.displayCircleImage(context, resId, imageView);
    }

    public void displayRoundImage(Context context, int resId, ImageView imageView, int radius) {
        adapter.displayRoundImage(context, resId, imageView, radius);
    }
}
