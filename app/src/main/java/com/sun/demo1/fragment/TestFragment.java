package com.sun.demo1.fragment;

import android.os.Bundle;

import com.sun.base.ui.fragment.BaseMvpFragment;
import com.sun.demo1.BuildConfig;
import com.sun.demo1.R;
import com.sun.demo1.databinding.FragmentTestBinding;

/**
 * @author Harper
 * @date 2021/12/2
 * note:
 */
public class TestFragment extends BaseMvpFragment {

    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void initView() {
        FragmentTestBinding binding = (FragmentTestBinding) mViewDataBinding;
        binding.handleText.setText(BuildConfig.VERSION_NAME);
    }

    @Override
    public void initData() {

    }

}
