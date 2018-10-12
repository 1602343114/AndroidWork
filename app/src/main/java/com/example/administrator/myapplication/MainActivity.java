package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String MAIN_FLAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MAIN_FLAG, "onCreate() is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MAIN_FLAG, "onStart() is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MAIN_FLAG, "onResume() is called");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(MAIN_FLAG, "onNewIntent() is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MAIN_FLAG, "onPause() is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MAIN_FLAG, "onDestroy() is called");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                Login();
                break;
            case R.id.bt_info:
                Info();
                break;
            case R.id.bt_deliver1:
                sendSimpleData1();
                break;
            case R.id.bt_deliver2:
                sendSimpleData2();
                break;
            case R.id.bt_data:
                sendSimpleDatas();
                break;
            case R.id.bt_obj:
                sendObject();
                break;
            case R.id.bt_array:
                sendArray();
                break;
            case R.id.bt_deliver:
                break;
            case R.id.bt_call:
                call();
                break;
            case R.id.bt_note:
                note();
                break;
            case R.id.bt_mail:
                mail();
                break;
            case R.id.bt_web:
                web();
                break;
            case R.id.bt_time:
                break;
            case R.id.bt_timer:
                break;
            case R.id.bt_clock:
                break;
            case R.id.bt_acData:
                break;
        }
    }

    private void Login() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void Info() {
//        Intent intent = new Intent(MainActivity.this, InformationActivity.class);
//        startActivity(intent);
        Intent intent = new Intent();
        intent.setAction("edu.niit.android.info");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("niit://edu.niit.android.info:666/target"));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private void sendSimpleData1() {
        Intent intent = new Intent(MainActivity.this, IntentActivity.class);
        intent.putExtra("flag", 1);
        intent.putExtra("version", 1.0f);
        startActivity(intent);
    }

    //通过Bundle对象封装
    private void sendSimpleData2() {
        Intent intent = new Intent(MainActivity.this, IntentActivity.class);
        intent.putExtra("flag", 2);
        Bundle bundle = new Bundle();
        bundle.putFloat("version", 1.0f);
        bundle.putString("activity", "MainActivity");
        intent.putExtras(bundle);
        startActivity(intent);

    }

    private void sendSimpleDatas() {
        Intent intent = new Intent(MainActivity.this, IntentActivity.class);
        intent.putExtra("flag", 3);

        int[] value = {1, 2, 3};
        intent.putExtra("int_data", value);

        Bundle bundle = new Bundle();
        bundle.putIntArray("another_data", value);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void sendObject() {
        Intent intent = new Intent(MainActivity.this, IntentActivity.class);
        intent.putExtra("flag", 4);

        User user = new User("艾思", "123456", 21);
        intent.putExtra("user", user);

        Bundle bundle = new Bundle();
        bundle.putSerializable("another_user", user);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    private void sendArray() {
        Intent intent = new Intent(MainActivity.this, IntentActivity.class);
        intent.putExtra("flag", 5);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User("艾思" + i, "123456", 21);
            users.add(user);
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable("another_user", (Serializable) users);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    private void call() {
        Uri uri = Uri.parse("tel:10086");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);

    }

    private void note() {
        Uri uri = Uri.parse("smsto:10086");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "hello");
        startActivity(intent);
    }

    private void mail() {

    }

    private void web() {
        Uri uri = Uri.parse("https://www.baidu.com");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(Intent.createChooser(intent, "请选择浏览器"));
    }

}
