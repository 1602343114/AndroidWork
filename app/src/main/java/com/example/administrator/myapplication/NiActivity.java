package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NiActivity extends AppCompatActivity {

    private EditText et_username;
    private TextView tv_result;
    private Button bt_inter;
    private Button bt_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ni);
        bt_inter=findViewById(R.id.bt_inter);
        et_username=findViewById(R.id.et_username);
        tv_result=findViewById(R.id.tv_result);
        bt_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }
    public void send(){
        Intent intent=new Intent(NiActivity.this,LiActivity.class);
        if(TextUtils.isEmpty(et_username.getText().toString())){
            Toast.makeText(NiActivity.this,"输入名称不能为空",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Bundle bundle=new Bundle();
        bundle.putString("username",et_username.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent,1000);
    }
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==1000&&resultCode==1001){
            String result_value=data.getStringExtra("result");
            tv_result.setText("评论内容返回为:"+result_value);

        }
    }

}
