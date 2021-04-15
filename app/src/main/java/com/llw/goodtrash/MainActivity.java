package com.llw.goodtrash;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.llw.goodtrash.contract.MainContract;
import com.llw.goodtrash.model.TrashNewsResponse;
import com.llw.goodtrash.ui.ImageInputActivity;
import com.llw.goodtrash.ui.TextInputActivity;
import com.llw.goodtrash.ui.VoiceInputActivity;
import com.llw.goodtrash.utils.Constant;
import com.llw.mvplibrary.mvp.MvpActivity;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.List;

/**
 * 主页面
 * @author llw
 */
public class MainActivity extends MvpActivity<MainContract.MainPresenter> implements MainContract.MainView {

    private static final String TAG = "MainActivity";
    //轮播
    private Banner banner;

    @Override
    public void initData(Bundle savedInstanceState) {
        banner = findViewById(R.id.banner);
        mPresenter.getTrashNews(10);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.MainPresenter createPresenter() {
        return new MainContract.MainPresenter();
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
        gotoActivity(ImageInputActivity.class);
    }

    /**
     * 进入Activity
     *
     * @param clazz 目标Activity
     */
    private void gotoActivity(Class<?> clazz) {
        startActivity(new Intent(MainActivity.this, clazz));
    }

    /**
     * 获取垃圾分类新闻成功返回
     *
     * @param response
     */
    @Override
    public void getTrashNewsResponse(TrashNewsResponse response) {
        if (response.getCode() == Constant.SUCCESS_CODE) {
            List<TrashNewsResponse.NewslistBean> list = response.getNewslist();
            if (list.size() > 0) {
                //数据显示
                showBanner(list);//轮播显示
            } else {
                showMsg("垃圾分类新闻为空");
            }
        } else {
            showMsg(response.getMsg());
        }
    }

    /**
     * 显示轮播图
     *
     * @param list
     */
    public void showBanner(List<TrashNewsResponse.NewslistBean> list) {
        banner.setAdapter(new BannerImageAdapter<TrashNewsResponse.NewslistBean>(list) {
            @Override
            public void onBindView(BannerImageHolder holder, TrashNewsResponse.NewslistBean data, int position, int size) {
                //显示轮播图片
                Glide.with(holder.itemView)
                        .load(data.getPicUrl())
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        })
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this));
    }

    /**
     * 获取垃圾分类新闻失败返回
     *
     * @param throwable 异常
     */
    @Override
    public void getTrashNewsFailed(Throwable throwable) {
        Log.d(TAG, "获取垃圾分类新闻失败：" + throwable.toString());
    }

}
