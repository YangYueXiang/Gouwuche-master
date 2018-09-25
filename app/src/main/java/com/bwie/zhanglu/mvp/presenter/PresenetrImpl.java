package com.bwie.zhanglu.mvp.presenter;

import com.bwie.zhanglu.mvp.contract.ICallBack;
import com.bwie.zhanglu.mvp.contract.MvpContract;
import com.bwie.zhanglu.mvp.model.IModel;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.mvp.presenter
 * @time 2018/9/22 9:44
 */
public class PresenetrImpl extends MvpContract.IPresenter {

    private IModel iModel;

    public PresenetrImpl() {

        iModel = new IModel();
    }

    @Override
    public void getData() {
        iModel.getConnData(new ICallBack() {
            @Override
            public void onSuccess(String result) {
                getView().onSuccess(result);
            }

            @Override
            public void onErrer() {
                getView().onErrer();
            }
        });
    }
}
