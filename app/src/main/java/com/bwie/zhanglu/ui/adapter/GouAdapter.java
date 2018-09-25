package com.bwie.zhanglu.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.zhanglu.mvp.model.bean.NewaBean;
import com.bwie.zhanglu.mvp.net.MyMessage;
import com.bwie.zhanglu.ui.activity.R;
import com.bwie.zhanglu.ui.holder.GouHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.ui.adapter
 * @time 2018/9/22 10:00
 */
public class GouAdapter extends RecyclerView.Adapter<GouHolder> {

    private Context context;
    private List<NewaBean.DataBean> data;

    public GouAdapter(Context context, List<NewaBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GouHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_cart_item, parent, false);
        GouHolder holder = new GouHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GouHolder holder, final int position) {
        holder.mTvItemShopcartShopname.setText(data.get(position).getSellerName());

        holder.mIvItemShopcartShopselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        List<NewaBean.DataBean.ListBean> list = data.get(position).getList();
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        WuAdapter wuAdapter = new WuAdapter(context, list);
        holder.recyclerView.setAdapter(wuAdapter);


        if (data.get(position).isSelect()){
            holder.mIvItemShopcartShopselect.setImageResource(R.drawable.shopcart_selected);

            for (int i = 0; i < data.get(position).getList().size(); i++) {
                data.get(position).getList().get(i).setSelected(1);
            }
            EventBus.getDefault().post(new MyMessage("2"));
        }else{
            holder.mIvItemShopcartShopselect.setImageResource(R.drawable.shopcart_unselected);

            for (int i = 0; i < data.get(position).getList().size(); i++) {
                data.get(position).getList().get(i).setSelected(0);
            }
            EventBus.getDefault().post(new MyMessage("2"));

        }

        holder.mIvItemShopcartShopselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setSelect(!data.get(position).isSelect());
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
