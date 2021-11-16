package com.sun.demo.activity;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sun.base.ui.activity.BaseMvpActivity;
import com.sun.demo.R;
import com.sun.demo.databinding.ActivityMultiTypeRecyclerViewBinding;
import com.sun.demo.model.ImgBean;
import com.sun.demo.model.response.MultiResponse;
import com.sun.demo.model.TextBean;
import com.sun.demo.widget.ImgViewBinder;
import com.sun.demo.widget.TextViewBinder;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author: Harper
 * @date: 2021/11/12
 * @note: 复杂的列表视图新写法MultiType
 */
public class MultiTypeRecyclerViewActivity extends BaseMvpActivity {

    private RecyclerView mRecyclerView;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MultiTypeRecyclerViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type_recycler_view);
        mRecyclerView = findViewById(R.id.multi_type_recycler_view);
        initData();
    }

    @Override
    public int layoutId() {
        return R.layout.activity_multi_type_recycler_view;
    }

    @Override
    public void initView() {
        ViewDataBinding viewDataBinding = getDataBinding();
        if (viewDataBinding != null) {
            ActivityMultiTypeRecyclerViewBinding binding = (ActivityMultiTypeRecyclerViewBinding) viewDataBinding;
            mRecyclerView = binding.multiTypeRecyclerView;
        }

    }

    @Override
    public void initData() {
        List<Object> items = new ArrayList<>();
        List<MultiResponse> responses = MultiResponse.getMultiResponse();
        for (int i = 0; i < responses.size(); i++) {
            MultiResponse response = responses.get(i);
            int type = response.getType();
            if (type == 0) {
                items.add(new TextBean(response.getContent()));
            } else {
                items.add(new ImgBean(response.getDrawableId()));
            }
        }
        MultiTypeAdapter adapter = new MultiTypeAdapter(items);
        TextViewBinder textViewBinder = new TextViewBinder();
        adapter.register(TextBean.class, textViewBinder);
        ImgViewBinder imgViewBinder = new ImgViewBinder();
        adapter.register(ImgBean.class, imgViewBinder);
        adapter.setItems(items);
        mRecyclerView.setAdapter(adapter);
    }
}