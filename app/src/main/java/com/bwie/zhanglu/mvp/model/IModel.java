package com.bwie.zhanglu.mvp.model;

import com.bwie.zhanglu.mvp.contract.ICallBack;
import com.bwie.zhanglu.mvp.contract.MvpContract;
import com.bwie.zhanglu.mvp.net.NetUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.mvp.model
 * @time 2018/9/22 9:43
 */
public class IModel implements MvpContract.BaseModel {

        String url = "https://www.zhaoapi.cn/product/getCarts?uid=71";
    @Override
    public void getConnData(final ICallBack iCallBack) {
        NetUtils.getInstance().get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCallBack.onErrer();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                iCallBack.onSuccess(response.body().string());
            }
        });
    }
}
