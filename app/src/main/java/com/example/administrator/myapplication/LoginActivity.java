package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_login);
        //获得组件
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        //设置button的监听
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_login:
                        String name=username.getText().toString();
                        String pwd=password.getText().toString();
                        login(name,pwd);
                        break;
                    case R.id.btn_register:
                        register();
                        break;

                }

            }
        });
    }

    private void login(String name, String pwd) {
        if("ni".equals(name)&&"123".equals(pwd)){
            Intent intent = new Intent(LoginActivity.this, informationActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
        }
    }

    private void register() {
    }

}
