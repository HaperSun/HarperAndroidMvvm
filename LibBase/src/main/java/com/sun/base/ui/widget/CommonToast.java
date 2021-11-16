package com.sun.base.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IntDef;
import androidx.annotation.StringRes;


import com.sun.base.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: Harper
 * @date: 2021/11/12
 * @note:
 */
public class CommonToast extends Toast {
    //警告类型，显示感叹号
    public static final int TYPE_WARNING = 1;
    //信息类型，显示对勾
    public static final int TYPE_CORRECT = 2;

    @IntDef({TYPE_WARNING, TYPE_CORRECT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TOAST_TYPE {
    }

    private final ImageView ivType;
    private final TextView tvTitle;

    public CommonToast(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_common_toast, null);
        ivType = view.findViewById(R.id.iv_type);
        tvTitle = view.findViewById(R.id.tv_title);
        setView(view);
    }

    public void setType(@TOAST_TYPE int type) {
        if (type == TYPE_WARNING) {
            ivType.setImageResource(R.mipmap.icon_warning_toast);
        } else {
            ivType.setImageResource(R.mipmap.icon_correct_toast);
        }
    }

    @Override
    public void setText(CharSequence s) {
        tvTitle.setText(s);
    }

    @Override
    public void setText(@StringRes int resId) {
        tvTitle.setText(resId);
    }

    public static class Builder {

        private final CommonToast mCommonToast;

        public Builder(Context context) {
            mCommonToast = new CommonToast(context);
        }

        public Builder setGravity(int gravity, int xOffset, int yOffset) {
            mCommonToast.setGravity(gravity, xOffset, yOffset);
            return this;
        }

        public Builder setDuration(int duration) {
            mCommonToast.setDuration(duration);
            return this;
        }

        public Builder setText(CharSequence s) {
            mCommonToast.setText(s);
            return this;
        }

        public Builder setType(@TOAST_TYPE int type) {
            mCommonToast.setType(type);
            return this;
        }

        public CommonToast build() {
            return mCommonToast;
        }
    }
}
