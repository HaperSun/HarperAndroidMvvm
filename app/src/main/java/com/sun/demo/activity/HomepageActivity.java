package com.sun.demo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sun.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Harper
 * @date: 2021/11/9
 * @note: 首页
 */
public class HomepageActivity extends AppCompatActivity {

    private Context mContext;
    private List<String> mTitles;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    private void initData() {
        mContext = HomepageActivity.this;
        mTitles = getTitles();
        Adapter adapter = new Adapter();
        mRecyclerView.setAdapter(adapter);
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("GreenDao在登录成功后，的一个使用实例");
        titles.add("一个模拟签名的实例");
        titles.add("handle的封装与使用");
        return titles;
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main_recycler_view,
                    parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.mTitleTextView.setText(mTitles.get(position));
            holder.itemView.setOnClickListener(v -> {
                doClick(position);
            });
        }

        private void doClick(int position) {
            switch (position) {
                case 0:
                    LoginActivity.startActivity(mContext);
                    break;
                case 1:
                    SignActivity.startActivity(mContext);
                    break;
                case 2:
                    HandleActivity.startActivity(mContext);
                    break;
                default:
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return mTitles.size();
        }

        class Holder extends RecyclerView.ViewHolder {

            TextView mTitleTextView;

            public Holder(View itemView) {
                super(itemView);
                mTitleTextView = itemView.findViewById(R.id.adapter_title_text);
            }
        }
    }


}