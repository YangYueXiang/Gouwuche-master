package com.bwie.zhanglu.mvp.base;

import java.lang.ref.WeakReference;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.mvp.base
 * @time 2018/9/22 9:37
 */
public abstract class BasePresenter<V extends BaseView> {

    private WeakReference<V> weakReference;

    public void onAttachView(V v){
        weakReference = new WeakReference(v);
    }

    public V getView(){
        return weakReference.get();
    }

    public void onDestory(){
        if (weakReference != null){
            weakReference.clear();
            weakReference= null;
        }
    }

    public boolean isAttachView(){
        return weakReference.get() != null && weakReference !=null;
    }


}
