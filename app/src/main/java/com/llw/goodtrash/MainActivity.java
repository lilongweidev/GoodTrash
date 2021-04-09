package com.llw.goodtrash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.llw.goodtrash.ui.TextInputActivity;
import com.llw.goodtrash.ui.VoiceInputActivity;
import com.llw.mvplibrary.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 进入文字输入页面
     */
    public void jumpTextInput(View view) {
        gotoActivity(TextInputActivity.class);
    }

    /**
     * 进入声音输入页面
     */
    public void jumpVoiceInput(View view) {
        gotoActivity(VoiceInputActivity.class);
    }

    /**
     * 进入图像输入页面
     */
    public void jumpImageInput(View view) {
        gotoActivity(VoiceInputActivity.class);
    }

    /**
     * 进入Activity
     *
     * @param clazz 目标Activity
     */
    private void gotoActivity(Class<?> clazz) {
        startActivity(new Intent(MainActivity.this, clazz));
    }


}
