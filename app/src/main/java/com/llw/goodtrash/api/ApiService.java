package com.llw.goodtrash.api;

import com.llw.goodtrash.model.TrashResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.llw.goodtrash.utils.Constant.KEY;

/**
 * API接口
 *
 * @author llw
 * @date 2021/3/30 15:13
 */
public interface ApiService {

    /**
     * 垃圾分类
     * @param word 物品名
     * @return TrashResponse 结果实体
     */
    @GET("/txapi/lajifenlei/index?key=" + KEY)
    Observable<TrashResponse> searchGoods(@Query("word") String word);
}
