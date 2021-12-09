package com.sun.demo1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sun.base.util.CommonUtils;
import com.sun.demo1.R;
import com.sun.demo1.model.SelectItemBean;

import java.util.List;

/**
 * @author Harper
 * @date 2021/11/24
 * note:
 */
public class MultiItemSelectAdapter extends RecyclerView.Adapter<MultiItemSelectAdapter.Holder> {

    private List<SelectItemBean.Multi> mBeans;

    public void setAdapterData(List<SelectItemBean.Multi> beans) {
        mBeans = beans;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_multi_item_select, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        SelectItemBean.Multi bean = mBeans.get(position);
        if (bean != null) {
            int selectIndex = bean.getSelectIndex();
            CommonUtils.setViewBackground(holder.mIv1, selectIndex == 0 ? R.mipmap.xf_bt_select : R.mipmap.xf_bt_select_un);
            CommonUtils.setViewBackground(holder.mIv2, selectIndex == 1 ? R.mipmap.xf_bt_select : R.mipmap.xf_bt_select_un);
            CommonUtils.setViewBackground(holder.mIv3, selectIndex == 2 ? R.mipmap.xf_bt_select : R.mipmap.xf_bt_select_un);
            holder.mIv1.setOnClickListener(v -> {
                if (mOnAdapterClickListener != null) {
                    mOnAdapterClickListener.onMultiClickSelect(position, 0);
                }
            });
            holder.mIv2.setOnClickListener(v -> {
                if (mOnAdapterClickListener != null) {
                    mOnAdapterClickListener.onMultiClickSelect(position, 1);
                }
            });
            holder.mIv3.setOnClickListener(v -> {
                if (mOnAdapterClickListener != null) {
                    mOnAdapterClickListener.onMultiClickSelect(position, 2);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mBeans.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        ImageView mIv1;
        ImageView mIv2;
        ImageView mIv3;

        public Holder(View itemView) {
            super(itemView);
            mIv1 = itemView.findViewById(R.id.iv_1);
            mIv2 = itemView.findViewById(R.id.iv_2);
            mIv3 = itemView.findViewById(R.id.iv_3);

        }
    }

    private OnAdapterClickListener mOnAdapterClickListener;

    public void setOnAdapterClickListener(OnAdapterClickListener onAdapterClickListener) {
        mOnAdapterClickListener = onAdapterClickListener;
    }

    public interface OnAdapterClickListener {

        void onMultiClickSelect(int position, int tag);

    }
}
