package com.example.strivezhe_chen.footballfans.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.strivezhe_chen.footballfans.R;
import com.example.strivezhe_chen.footballfans.utils.PasswordInputView;
import com.example.strivezhe_chen.footballfans.utils.SharepreferenceHelper2Password;

/**
 * Created by StriveZhe_Chen on 2017/3/7.
 *
 */

public class SettingPwdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_setpwd);
        final PasswordInputView passwordInputView1 = (PasswordInputView) findViewById(R.id.setpassword);
        final PasswordInputView passwordInputView2 = (PasswordInputView) findViewById(R.id.setpassword2);
        Button setpwdBtn = (Button) findViewById(R.id.setpwdbtn);

        setpwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordInputView1.getText().toString();
                String confirm = passwordInputView2.getText().toString();
                if (password.equals(confirm)){
                    SharepreferenceHelper2Password helper = new SharepreferenceHelper2Password();
                    helper.saveSharepreference(SettingPwdActivity.this,password);
                    finish();
                }else {
                    Toast.makeText(SettingPwdActivity.this,"两次输入密码不一致",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
