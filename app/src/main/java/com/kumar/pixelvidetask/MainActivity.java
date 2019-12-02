package com.kumar.pixelvidetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity
{
    TextInputEditText mInputUserName,mInputPassword;
    Button mBtnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews()
    {
        mInputUserName=(TextInputEditText)findViewById(R.id.user_name_input_login_activity);
        mInputPassword=(TextInputEditText)findViewById(R.id.password_input_login_activity);
        mBtnLogin=(Button)findViewById(R.id.login_btn_login_activity);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (!checkLoginValidations(mInputUserName.getText().toString().trim(),mInputPassword.getText().toString().trim()))
                {
                    Intent i=new Intent(MainActivity.this,DashBoardActivity.class);
                    i.putExtra("login_user_name",mInputUserName.getText().toString().trim());
                    startActivity(i);
                }

            }
        });
    }

    private boolean checkLoginValidations(String userName,String password)
    {
        if (userName.isEmpty())
        {
            mInputUserName.setError("User Name Required");
            mInputUserName.requestFocus();
            return  true;
        }
        if (password.isEmpty())
        {
            mInputPassword.setError("User Name Required");
            mInputPassword.requestFocus();
            return true;
        }
        return false;
    }
}
