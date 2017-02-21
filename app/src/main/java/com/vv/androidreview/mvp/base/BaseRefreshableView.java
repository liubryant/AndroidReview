package com.vv.androidreview.mvp.base;

import android.view.ViewGroup;

/**
 * Author：Vv on .
 * Mail：envyfan@qq.com
 * Description：
 */

public interface BaseRefreshableView<T, R extends ViewGroup> extends BaseView<T> {

    void setRefreshView(R refreshView);
}