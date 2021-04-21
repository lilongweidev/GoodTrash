package com.llw.goodtrash.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.llw.goodtrash.R;
import com.llw.goodtrash.adapter.HistoryAdapter;
import com.llw.goodtrash.model.History;
import com.llw.mvplibrary.base.BaseActivity;

import org.litepal.LitePal;

import java.util.List;

/**
 * 历史记录
 * @author llw
 */
public class HistoryActivity extends BaseActivity {

    //工具栏
    private Toolbar toolbar;
    //空数据布局
    private LinearLayout layEmptyData;
    //历史列表
    private RecyclerView rvHistory;
    //适配器
    private HistoryAdapter mAdapter;
    //历史数据列表
    private List<History> mList;

    @Override
    public void initData(Bundle savedInstanceState) {
        initView();
    }

    /**
     * 页面初始化
     */
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        //设置页面状态栏
        setStatubar(this, R.color.white, true);
        back(toolbar,false);
        layEmptyData = findViewById(R.id.lay_empty_data);
        rvHistory = findViewById(R.id.rv_history);

        //获取数据库中的历史数据
        mList = LitePal.findAll(History.class);
        if (mList.size() > 0) {
            //设置列表的数据
            mAdapter = new HistoryAdapter(R.layout.item_history_rv, mList);
            rvHistory.setLayoutManager(new LinearLayoutManager(context));
            rvHistory.setAdapter(mAdapter);
            layEmptyData.setVisibility(View.GONE);
            rvHistory.setVisibility(View.VISIBLE);
        } else {
            //隐藏列表
            layEmptyData.setVisibility(View.VISIBLE);
            rvHistory.setVisibility(View.GONE);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_history;
    }
}