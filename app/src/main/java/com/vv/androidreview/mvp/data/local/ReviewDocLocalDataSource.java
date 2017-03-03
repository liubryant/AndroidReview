package com.vv.androidreview.mvp.data.local;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.vv.androidreview.cache.CacheHelper;
import com.vv.androidreview.mvp.data.entity.Content;
import com.vv.androidreview.mvp.data.entity.Point;
import com.vv.androidreview.mvp.data.entity.Unit;
import com.vv.androidreview.mvp.data.repository.interfaces.OnLoadDataCallBack;
import com.vv.androidreview.mvp.data.repository.interfaces.ReviewDocDataSource;
import com.vv.androidreview.mvp.system.CodeConfig;
import com.vv.androidreview.mvp.system.StaticValues;

import java.util.List;

/**
 * Created by Vv
 * 2016/9/1 0001.
 * Version 1.0
 * Description：
 */

public class ReviewDocLocalDataSource implements ReviewDocDataSource {

    private Context mContext;

    public ReviewDocLocalDataSource(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getContents(@NonNull OnLoadDataCallBack<List<Content>> loadContentsCallback, Point point, Boolean isReadCache) {

    }

    @Override
    public void getMoreContents(@NonNull OnLoadDataCallBack<List<Content>> loadContentsCallback, Point point, int currentPage, int currentItemCount) {

    }

    /**
     * 获取单元列表
     *
     * @param loadUnitsCallback 回调
     * @param isReadCache       是否需要缓存 (具体 local 和 remote可以传null)
     */
    @Override
    public void getUnits(@NonNull final OnLoadDataCallBack<List<Unit>> loadUnitsCallback, Boolean isReadCache) {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Unit> units = (List<Unit>) CacheHelper.readObject(mContext, CacheHelper.GROUP_UNIT_LIST_CACHE_KEY);
                    loadUnitsCallback.onSuccess(units);
                } catch (Exception e) {
                    loadUnitsCallback.onFail(CodeConfig.Error.CACHE, StaticValues.REQUEST_CACHE_ERROR);
                }

            }
        });
    }

    /**
     * 获取知识点列表
     *
     * @param loadPointsCallback 回调
     * @param isReadCache        是否需要缓存 (具体 local 和 remote可以传null)
     */
    @Override
    public void getPoints(@NonNull final OnLoadDataCallBack<List<Point>> loadPointsCallback, Boolean isReadCache) {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Point> points = (List<Point>) CacheHelper.readObject(mContext, CacheHelper.GROUP_POINT_LIST_CACHE_KEY);
                    loadPointsCallback.onSuccess(points);
                } catch (Exception e) {
                    loadPointsCallback.onFail(CodeConfig.Error.CACHE, StaticValues.REQUEST_CACHE_ERROR);
                }

            }
        });
    }
}