package com.example.strivezhe_chen.footballfans.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.strivezhe_chen.footballfans.BaseActivity;
import com.example.strivezhe_chen.footballfans.MainActivity;
import com.example.strivezhe_chen.footballfans.R;
import com.example.strivezhe_chen.footballfans.utils.SharepreferenceHelper2Font;

/**
 * Created by StriveZhe_Chen on 2017/3/6.
 *
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    RadioButton button1,button2;
    private Button  button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        button1 = (RadioButton) findViewById(R.id.normal);
        button2 = (RadioButton) findViewById(R.id.big);
        button = (Button) findViewById(R.id.button_exit);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.normal:
                button1.setChecked(true);
                button2.setChecked(false);
                SharepreferenceHelper2Font sharepreferenceHelper2Font = new SharepreferenceHelper2Font();
                sharepreferenceHelper2Font.saveSharepreference(this,1);
                break;
            case R.id.big:
                button1.setChecked(false);
                button2.setChecked(true);
                sharepreferenceHelper2Font = new SharepreferenceHelper2Font();
                sharepreferenceHelper2Font.saveSharepreference(this,1.2f);
                break;
            case R.id.button_exit:
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
               break;
        }
    }
}
