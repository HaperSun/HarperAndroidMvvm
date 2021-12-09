package com.sun.demo1.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sun.demo1.R;
import com.sun.demo1.model.TextBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author Harper
 * @date 2021/11/11
 * note:
 */
public class TextViewBinder extends ItemViewBinder<TextBean, TextViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull TextBean textBean) {
        holder.mTextView.setText(textBean.getText());
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.item_text);
        }
    }
}
