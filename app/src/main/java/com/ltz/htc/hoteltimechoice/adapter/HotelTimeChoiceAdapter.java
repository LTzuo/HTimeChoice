package com.ltz.htc.hoteltimechoice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ltz.htc.hoteltimechoice.R;

/**
 * RecyclerView适配器
 * Created by 1 on 2017/9/27.
 */
public class HotelTimeChoiceAdapter extends RecyclerView.Adapter<ViewHolder>{

    private Context context;

    private String[] mDatas;

    private HtcClickListener mHtcClickListener;

    private  String text1,text2;

    //计算点击事件的次数
    private int count = 0;

    public interface  HtcClickListener{
       void onHtcClick(int position,String data);
    }

    public void setOnHTcClickListener(HtcClickListener mHtcClickListener){
        this.mHtcClickListener = mHtcClickListener;
    }

    public HotelTimeChoiceAdapter(Context context, String[] data){
        this.context = context;
        this.mDatas = data;
    }

    public String getText1(){
        return text1;
    }

    public String getText2(){
        return text2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        HTCViewHolder holder = new HTCViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
       final  HTCViewHolder mHolder = (HTCViewHolder) holder;

        mHolder.tv.setText(mDatas[position]);

        if(mHtcClickListener != null){
                mHolder.tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(count >= 2){
                            Toast.makeText(context,"你点了太多啦",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (count == 0) {
                            text1 = mDatas[position];
                        } else if (count == 1) {
                            if (Integer.parseInt(text1) >= Integer.parseInt(mDatas[position])) {
                                Toast.makeText(context, "结束时间请大于开始时间", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            text2 = mDatas[position];
                        }
                        count++;
                        mHtcClickListener.onHtcClick(position, mDatas[position]);
                        mHolder.tv.setBackgroundResource(R.drawable.bg2);
                        Toast.makeText(context, "count"+count, Toast.LENGTH_SHORT).show();
                    }
                });
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.length;
    }

    class HTCViewHolder extends ViewHolder{

        TextView tv;

        public HTCViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item);
        }


    }

}
