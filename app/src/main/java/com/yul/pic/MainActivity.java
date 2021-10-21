package com.yul.pic;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {
    private static final String picUrl = "http://imgsrc.baidu.com/imgad/pic/item/267f9e2f07082838b5168c32b299a9014c08f1f9.jpg";
    private ImageView glideIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        glideIv = findViewById(R.id.glide_iv);
        // 网络高斯模糊
//        GlidePackLoader.getInstance().displayBlurImage(this, picUrl, glideIv, DiskCacheStrategy.AUTOMATIC, R.mipmap.place, R.mipmap.error, 25);
        // 本地高斯模糊
//        GlidePackLoader.getInstance().displayBlurImage(this, R.mipmap.error, glideIv,25);
        // 圆形图片加载
//        GlidePackLoader.getInstance().displayCircleImage(this, picUrl, glideIv, DiskCacheStrategy.AUTOMATIC, R.mipmap.place, R.mipmap.error);
        // 自定义角度圆形图片加载
//        GlidePackLoader.getInstance().displayRoundImage(this, picUrl, glideIv, DiskCacheStrategy.AUTOMATIC, R.mipmap.place, R.mipmap.error, 55);
    }
}