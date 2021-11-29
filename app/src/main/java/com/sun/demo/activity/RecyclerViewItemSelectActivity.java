package com.sun.demo.activity;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.sun.base.ui.activity.BaseMvpActivity;
import com.sun.demo.R;
import com.sun.demo.adapter.MultiItemSelectAdapter;
import com.sun.demo.adapter.SingleItemSelectAdapter;
import com.sun.demo.databinding.ActivityRecyclerViewItemSelectBinding;
import com.sun.demo.model.SelectItemBean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewItemSelectActivity extends BaseMvpActivity implements MultiItemSelectAdapter.OnAdapterClickListener, SingleItemSelectAdapter.OnAdapterClickListener {

    private RecyclerView mMultiRecyclerView;
    private RecyclerView mSingleRecyclerView;
    private List<SelectItemBean.Multi> mMultiBeans;
    private List<SelectItemBean.Single> mSingleBeans;
    private MultiItemSelectAdapter mMultiAdapter;
    private SingleItemSelectAdapter mSingleAdapter;
    private int mSingleSelectIndex;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RecyclerViewItemSelectActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_recycler_view_item_select;
    }

    @Override
    public void initView() {
        ViewDataBinding viewDataBinding = getDataBinding();
        if (viewDataBinding != null) {
            ActivityRecyclerViewItemSelectBinding binding = (ActivityRecyclerViewItemSelectBinding) viewDataBinding;
            mMultiRecyclerView = binding.itemHasMulSelect;
            mSingleRecyclerView = binding.itemSingleSelect;
            mMultiBeans = getSelectItemMultiBean();
            mSingleBeans = getSelectItemSingleBean();
        }
    }

    private List<SelectItemBean.Multi> getSelectItemMultiBean() {
        List<SelectItemBean.Multi> beans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            beans.add(new SelectItemBean.Multi(i % 3));
        }
        return beans;
    }

    private List<SelectItemBean.Single> getSelectItemSingleBean() {
        List<SelectItemBean.Single> singles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i % 4 == 1){
                mSingleSelectIndex = i;
                singles.add(new SelectItemBean.Single(true));
            }else {
                singles.add(new SelectItemBean.Single(false));
            }
        }
        return singles;
    }


    @Override
    public void initData() {
        mMultiAdapter = new MultiItemSelectAdapter();
        mMultiAdapter.setAdapterData(mMultiBeans);
        mMultiRecyclerView.setAdapter(mMultiAdapter);
        mMultiAdapter.setOnAdapterClickListener(this);


        mSingleAdapter = new SingleItemSelectAdapter();
        mSingleAdapter.setAdapterData(mSingleBeans);
        mSingleRecyclerView.setAdapter(mSingleAdapter);
        mSingleAdapter.setOnAdapterClickListener(this);
    }

    @Override
    public void onMultiClickSelect(int position, int tag) {
        SelectItemBean.Multi bean = mMultiBeans.get(position);
        if (bean != null) {
            int selectIndex = bean.getSelectIndex();
            if (selectIndex != tag) {
                bean.setSelectIndex(tag);
                mMultiAdapter.notifyItemChanged(position);
            }
        }
    }

    @Override
    public void onSingleClickSelect(int position) {
        if (mSingleSelectIndex != position){
            mSingleSelectIndex = position;
            for (int i = 0; i < mSingleBeans.size(); i++) {
                SelectItemBean.Single single = mSingleBeans.get(i);
                single.setSelect(i == mSingleSelectIndex);
            }
            mSingleAdapter.notifyDataSetChanged();
        }
    }
}