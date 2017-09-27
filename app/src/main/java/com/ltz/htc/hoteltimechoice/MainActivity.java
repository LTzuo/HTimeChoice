package com.ltz.htc.hoteltimechoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ltz.htc.hoteltimechoice.adapter.HotelTimeChoiceAdapter;

/**
 * 基于RecyclerView的酒店时间入离选择
 */
public class MainActivity extends AppCompatActivity implements  HotelTimeChoiceAdapter.HtcClickListener{

    RecyclerView mRecyclerView;

    HotelTimeChoiceAdapter mAdapter;

    String[] mData = new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new HotelTimeChoiceAdapter(this,mData);
        mAdapter.setOnHTcClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        // 设置RecyclerView的布局管理
        LinearLayoutManager mLayoutManager = new GridLayoutManager(this, 6);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }


    @Override
    public void onHtcClick(int position,String data) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
}
