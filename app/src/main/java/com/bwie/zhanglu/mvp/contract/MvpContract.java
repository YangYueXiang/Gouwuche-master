package com.bwie.zhanglu.mvp.contract;

import com.bwie.zhanglu.mvp.base.BasePresenter;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.mvp.contract
 * @time 2018/9/22 9:40
 */
public interface MvpContract {

    public interface BaseModel{
        public void getConnData(ICallBack iCallBack);
    }

    public abstract class IPresenter extends BasePresenter{

        public abstract void getData();
    }


}
