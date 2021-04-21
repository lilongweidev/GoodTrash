package com.llw.goodtrash.utils;

import android.util.Log;
import com.llw.goodtrash.model.History;
import com.llw.goodtrash.model.TrashResponse;
import com.llw.mvplibrary.network.utils.DateUtil;
import org.litepal.LitePal;
import java.util.List;

/**
 * 历史记录帮助类
 *
 * @author llw
 */
public class HistoryHelper {

    public static final String TAG = "HistoryHelper";

    /**
     * 查询所有历史记录
     *
     * @return 结果列表
     */
    public static List<History> queryAllHistory() {
        return LitePal.findAll(History.class);
    }

    /**
     * 通过物品名称查询历史
     *
     * @return 结果列表
     */
    public static List<History> queryHistoryByName(String name) {
        return LitePal.select(name).find(History.class);
    }

    /**
     * 根据Id删除历史记录
     *
     * @param id id
     */
    public static void deleteHistoryById(long id) {
        LitePal.delete(History.class, id);
    }

    /**
     * 保存历史记录
     *
     * @param list 需要保存的数据
     * @param word 物品名称
     */
    public static void saveHistory(List<TrashResponse.NewslistBean> list,String word) {
        for (TrashResponse.NewslistBean bean : list) {
            //遍历返回数据，找出返回结果中与搜索内容一致的数据，保存到数据表中
            if (bean.getName().equals(word)) {
                //保存数据前先查询是否存在数据
                List<History> historyList = queryAllHistory();
                for (History history : historyList) {
                    if (!history.getName().equals(bean.getName())) {
                        //不存在则直接保存
                        History historyBean = new History();
                        historyBean.setName(bean.getName());
                        historyBean.setType(bean.getType());
                        historyBean.setAipre(bean.getAipre());
                        historyBean.setExplain(bean.getExplain());
                        historyBean.setContain(bean.getContain());
                        historyBean.setTip(bean.getTip());
                        //添加历史记录的保存时间
                        historyBean.setDateTime(DateUtil.getDateTime());
                        historyBean.save();
                        if (history.isSaved()) {
                            Log.d(TAG, "保存历史记录成功");
                        } else {
                            Log.d(TAG, "保存历史记录失败");
                        }
                    } else {
                        Log.d(TAG, "记录已存在");
                    }
                }
            }
        }


    }
}
