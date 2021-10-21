package com.yul.pic.transform;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import java.security.MessageDigest;


/**
 * 实现高斯模糊
 */
public class BlurBitmapTranformation extends BitmapTransformation {

    private static final int VERSION = 1;
    private static final String ID =
            "com.yul.pic.transform.BlurBitmapTranformation." + VERSION;

    private static final int MAX_RADIUS = 25;
    private static final int DEFAULT_DOWN_SAMPLING = 1;

    private final int radius;
    private final int sampling;
    private Context context;

    public BlurBitmapTranformation() {
        this(MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public BlurBitmapTranformation(int radius) {
        this(radius, DEFAULT_DOWN_SAMPLING);
    }

    public BlurBitmapTranformation(int radius, int sampling) {
        this.radius = radius;
        this.sampling = sampling;
    }

    @Override
    protected Bitmap transform(@NonNull Context context, @NonNull BitmapPool pool,
                               @NonNull Bitmap toTransform, int outWidth, int outHeight) {

        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        int scaledWidth = width / sampling;
        int scaledHeight = height / sampling;

        Bitmap bitmap = pool.get(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);

        bitmap.setDensity(toTransform.getDensity());

        Canvas canvas = new Canvas(bitmap);
        canvas.scale(1 / (float) sampling, 1 / (float) sampling);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(toTransform, 0, 0, paint);

        try {
            bitmap = RSBlur.blur(context, bitmap, radius);
        } catch (RSRuntimeException e) {
            bitmap = FastBlur.blur(bitmap, radius, true);
        }

        return bitmap;
    }

    @Override
    public String toString() {
        return "BlurTransformation(radius=" + radius + ", sampling=" + sampling + ")";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BlurBitmapTranformation &&
                ((BlurBitmapTranformation) o).radius == radius &&
                ((BlurBitmapTranformation) o).sampling == sampling;
    }

    @Override
    public int hashCode() {
        return ID.hashCode() + radius * 1000 + sampling * 10;
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + radius + sampling).getBytes(CHARSET));
    }
}