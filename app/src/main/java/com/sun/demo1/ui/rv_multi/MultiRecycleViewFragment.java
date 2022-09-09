package com.sun.demo1.ui.rv_multi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.sun.base.base.BaseFragment;
import com.sun.demo1.BR;
import com.sun.demo1.R;
import com.sun.demo1.databinding.FragmentMultiRvBinding;


/**
 * @author: Harper
 * @date: 2022/9/9
 * @note: RecycleView多布局实现
 */
public class MultiRecycleViewFragment extends BaseFragment<FragmentMultiRvBinding, MultiRecycleViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_multi_rv;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
