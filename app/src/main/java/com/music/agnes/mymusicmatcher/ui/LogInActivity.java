package com.music.agnes.mymusicmatcher.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.music.agnes.mymusicmatcher.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogInActivity extends Activity  implements View.OnClickListener {

    @BindView(R.id.registerTextView)
    TextView mRegisterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mRegisterTextView) {
            Intent intent = new Intent(LogInActivity.this, CreateAccountActivity.class);
            startActivity(intent);
            finish();
        }
    }
}