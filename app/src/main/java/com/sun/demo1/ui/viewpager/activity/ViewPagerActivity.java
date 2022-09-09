package com.sun.demo1.ui.viewpager.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.google.android.material.tabs.TabLayout;
import com.sun.base.base.BaseActivity;
import com.sun.base.util.ToastUtil;
import com.sun.demo1.BR;
import com.sun.demo1.R;
import com.sun.demo1.databinding.FragmentViewpagerBinding;
import com.sun.demo1.ui.viewpager.adapter.ViewPagerBindingAdapter;
import com.sun.demo1.ui.viewpager.vm.ViewPagerViewModel;

/**
 * @author: Harper
 * @date: 2022/9/9
 * @note: ViewPager绑定的例子, 更多绑定方式，请参考 https://github.com/evant/binding-collection-adapter
 * 所有例子仅做参考,千万不要把它当成一种标准,毕竟主打的不是例子,业务场景繁多,理解如何使用才最重要。
 */
public class ViewPagerActivity extends BaseActivity<FragmentViewpagerBinding, ViewPagerViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.fragment_viewpager;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initData() {
        // 使用 TabLayout 和 ViewPager 相关联
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));
        //给ViewPager设置adapter
        binding.setAdapter(new ViewPagerBindingAdapter());
    }

    @Override
    public void initViewObservable() {
        viewModel.itemClickEvent.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String text) {
                ToastUtil.showShort("position：" + text);
            }
        });
    }
}
