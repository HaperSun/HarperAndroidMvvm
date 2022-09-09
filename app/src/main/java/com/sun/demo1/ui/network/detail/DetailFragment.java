package com.sun.demo1.ui.network.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sun.base.base.BaseFragment;
import com.sun.demo1.BR;
import com.sun.demo1.R;
import com.sun.demo1.databinding.FragmentDetailBinding;
import com.sun.demo1.entity.DemoEntity;


/**
 * @author: Harper
 * @date: 2022/9/9
 * @note: 详情界面
 */
public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailViewModel> {

    private DemoEntity.ItemsEntity entity;

    @Override
    public void initParam() {
        //获取列表传入的实体
        Bundle mBundle = getArguments();
        if (mBundle != null) {
            entity = mBundle.getParcelable("entity");
        }
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_detail;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        viewModel.setDemoEntity(entity);
    }
}
