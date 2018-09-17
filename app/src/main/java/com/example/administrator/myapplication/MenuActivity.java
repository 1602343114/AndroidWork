package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tv_name=findViewById(R.id.tv_name);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        tv_name.setText("欢迎"+name+"来到您的空间");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_info_maintain:
                Toast.makeText(MenuActivity.this,"个人信息维护",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_setting:
                Toast.makeText(MenuActivity.this,"设置",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_questionnaire:
                Toast.makeText(MenuActivity.this,"问卷调查",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_about:
                Toast.makeText(MenuActivity.this,"关于",Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}
