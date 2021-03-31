package com.llw.goodtrash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.llw.goodtrash.adapter.SearchGoodsAdapter;
import com.llw.goodtrash.contract.MainContract;
import com.llw.goodtrash.model.TrashResponse;
import com.llw.goodtrash.utils.Constant;
import com.llw.mvplibrary.base.BaseActivity;
import com.llw.mvplibrary.mvp.MvpActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

}
