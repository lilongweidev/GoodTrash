package com.llw.goodtrash.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.goodtrash.R;
import com.llw.mvplibrary.base.BaseActivity;

/**
 * 图像输入物品进行垃圾分类
 *
 * @author llw
 * @date 2021/4/7 11:04
 */
public class ImageInputActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView ivPicture;
    private Button btnWebPicture, btnOpenAlbum, btnTakePhoto;
    private LinearLayout layRecognitionResult,layClassificationResult;
    private RecyclerView rvRecognitionResult,rvClassificationResult;

    @Override
    public void initData(Bundle savedInstanceState) {
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        ivPicture = findViewById(R.id.iv_picture);
        findViewById(R.id.btn_web_picture).setOnClickListener(this);
        findViewById(R.id.btn_open_album).setOnClickListener(this);
        findViewById(R.id.btn_take_photo).setOnClickListener(this);
        layRecognitionResult = findViewById(R.id.lay_recognition_result);
        layClassificationResult = findViewById(R.id.lay_classification_result);
        rvRecognitionResult = findViewById(R.id.rv_recognition_result);
        rvClassificationResult = findViewById(R.id.rv_classification_result);
        back(toolbar, true);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_image_input;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_web_picture://网络图片

                break;
            case R.id.btn_open_album://相册图片

                break;
            case R.id.btn_take_photo://拍照图片

                break;
            default:
                break;
        }
    }
}
