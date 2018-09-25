package com.bwie.zhanglu.mvp.base;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.mvp.base
 * @time 2018/9/22 9:36
 */
public interface BaseView <V>{

    public void onSuccess(V v);

    public  void onErrer();
}
