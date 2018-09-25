package com.bwie.zhanglu.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.zhanglu.mvp.model.bean.NewaBean;
import com.bwie.zhanglu.mvp.net.MyMessage;
import com.bwie.zhanglu.ui.activity.R;
import com.bwie.zhanglu.ui.holder.WuHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.ui.adapter
 * @time 2018/9/22 10:15
 */
public class WuAdapter extends RecyclerView.Adapter<WuHolder>{

    private Context context;
    private List<NewaBean.DataBean.ListBean> list;

    public WuAdapter(Context context, List<NewaBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public WuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        WuHolder wuHolder = new WuHolder(view);
        return wuHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WuHolder holder, final int position) {

        holder.mTvItemShopcartClothname.setText(list.get(position).getTitle());
        holder.mTvItemShopcartClothPrice.setText(String.valueOf(list.get(position).getPrice()));
        holder.mTvItemShopcartClothColor.setText(list.get(position).getCreatetime());
        holder.mEtItemShopcartClothNum.setText(String.valueOf(list.get(position).getNum()));

        String regex = "\\|";

        String[] split = list.get(position).getImages().split(regex);
        Uri parse = Uri.parse(split[0]);
        holder.mIvItemShopcartClothPic.setImageURI(parse);


        //        选中
        if (list.get(position).getSelected() % 2 ==1){
            holder.mTvItemShopcartClothselect.setImageResource(R.drawable.shopcart_selected);
            EventBus.getDefault().post(new MyMessage("2"));
        }else{
            holder.mTvItemShopcartClothselect.setImageResource(R.drawable.shopcart_unselected);
            EventBus.getDefault().post(new MyMessage("2"));
        }
        holder.mTvItemShopcartClothselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = list.get(position).getSelected();
                selected++;
                int i = selected % 2;
                list.get(position).setSelected(i);

                notifyDataSetChanged();
            }
        });

//        加
        holder.mIvItemShopcartClothAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = list.get(position).getNum();
                if (num<=30){
                    num++;
                    list.get(position).setNum(num);
                    EventBus.getDefault().post(new MyMessage("2"));
                    notifyDataSetChanged();
                }

            }
        });

//        减
        holder.mIvItemShopcartClothMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = list.get(position).getNum();
                if (num>=1){
                    num--;
                    list.get(position).setNum(num);
                    EventBus.getDefault().post(new MyMessage("2"));
                    notifyDataSetChanged();
                }

            }
        });

//        删除
        holder.mIvItemShopcartClothDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                EventBus.getDefault().post(new MyMessage("2"));
                notifyDataSetChanged();
            }
        });
 }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
