package com.sun.demo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sun.demo.R;

/**
 * @author: Harper
 * @date: 2021/11/10
 * @note: 模拟签名
 */
public class SignActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SignActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
    }
}