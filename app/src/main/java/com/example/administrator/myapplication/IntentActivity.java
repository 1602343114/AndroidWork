package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class IntentActivity extends AppCompatActivity {
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        tvData = findViewById(R.id.tv_value);

        //获取main的Intent传递到数据
        Intent intent = getIntent();
        int flag = intent.getIntExtra("flag", 1);
        String value = "";
        switch (flag) {
            case 1:
                float version = intent.getFloatExtra("version", 0.0f);
                value = "Version:" + String.valueOf(version);
                break;
            case 2:
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    version = bundle.getFloat("version");
                    String activityName = bundle.getString("activity");
                    value = "version:" + version + "\nactivityName:" + activityName;
                }
                break;
            case 3:
                int[] value1 = intent.getIntArrayExtra("int_data");
//                value = "int_data:" + value1;
                for (int i = 0; i < value1.length; i++) {
                    value += "\nint_data:" + value1[i];
                }

                bundle = intent.getExtras();
                if (bundle != null) {
                    int[] value2 = bundle.getIntArray("another_data");
//                    value += "\nanother_data:" + value2;
                    for (int i = 0; i < value2.length; i++) {
                        value += "\nanother_data:" + value2[i];
                    }

                }
                break;
            case 4:
                User user = (User) intent.getSerializableExtra("user");
                value = "user:" + user;

                bundle = intent.getExtras();
                if (bundle != null) {
                    User anotherUser = (User) bundle.getSerializable("another_user");
                    value += "\nanother_user:" + anotherUser;
                }
                break;
            case 5:
                bundle = intent.getExtras();
                if (bundle != null) {
                    List<User> users = (List<User>) bundle.getSerializable("another_user");
                    value += "\nanother_user:" + users;
                }
                break;
        }
        tvData.setText(value);
    }
}
