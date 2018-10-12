package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LiActivity extends Activity {
    private Button bt_yes;
    private Button bt_no;
    private TextView tv_word;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li);
        get();

    }

    public void get() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("username");
        tv_word = findViewById(R.id.tv_word);
        String words = name.toString() + "同学:学习Android有没有信心？";
        tv_word.setText(words);
        bt_yes = findViewById(R.id.bt_yes);
        bt_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                result = "是";
                intent.putExtra("result", result);
                setResult(1001, intent);
                finish();
            }
        });
        bt_no = findViewById(R.id.bt_no);
        bt_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                result = "否";
                intent.putExtra("result", result);
                setResult(1001, intent);
                finish();
            }
        });
    }
}
