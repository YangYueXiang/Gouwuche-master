package com.bwie.zhanglu.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.zhanglu.ui.activity.R;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.ui.holder
 * @time 2018/9/22 10:01
 */
public class GouHolder extends RecyclerView.ViewHolder {

    public ImageView mIvItemShopcartShopselect;
    public TextView mTvItemShopcartShopname;
    public RecyclerView recyclerView;

    public GouHolder(View itemView) {
        super(itemView);

        this.mIvItemShopcartShopselect = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_shopselect);
        this.mTvItemShopcartShopname = (TextView) itemView.findViewById(R.id.tv_item_shopcart_shopname);
        recyclerView = itemView.findViewById(R.id.recycler_view);
    }


}
