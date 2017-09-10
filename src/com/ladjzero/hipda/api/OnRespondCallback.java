package com.ladjzero.hipda.api;

/**
 * Created by chenzhuo on 8/29/17.
 */
public interface OnRespondCallback<T> {
    void onRespond(Response<T> res);
}
