package com.example.strivezhe_chen.footballfans.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.strivezhe_chen.footballfans.Activity.SettingPwdActivity;
import com.example.strivezhe_chen.footballfans.Activity.ShoucangActivity;
import com.example.strivezhe_chen.footballfans.R;
import com.example.strivezhe_chen.footballfans.utils.PasswordInputView;
import com.example.strivezhe_chen.footballfans.utils.SharepreferenceHelper2Password;

/**
 * Created by StriveZhe_Chen on 2017/3/1.
 *
 */

public class ForthFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forth,container,false);

        final PasswordInputView passwordInputView = (PasswordInputView) view.findViewById(R.id.passwordInputView);
        Button button = (Button) view.findViewById(R.id.queren);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharepreferenceHelper2Password sharepreferenceHelper = new SharepreferenceHelper2Password();
                final String bendipassword = sharepreferenceHelper.getSharereference(getContext());
                System.out.println("---------"+bendipassword);
               String password = passwordInputView.getText().toString();
                if (password.equals(bendipassword)){
                    Intent intent = new Intent(getContext(),ShoucangActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            SharepreferenceHelper2Password sharepreferenceHelper = new SharepreferenceHelper2Password();
            String bendipassword = sharepreferenceHelper.getSharereference(getContext());
            if (bendipassword.equals("")){
                Intent intent = new Intent(getContext(), SettingPwdActivity.class);
                startActivity(intent);
            }else {
                System.out.println(bendipassword);
            }
        }
    }
}
