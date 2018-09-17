package com.example.administrator.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.Toast;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private EditText username;
    private RadioGroup rgSex;
    private CheckBox chbJava;
    private CheckBox chbAndroid;
    private CheckBox chbWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        imageView = findViewById(R.id.img_avatar);
        username = findViewById(R.id.et_username);
        rgSex = findViewById(R.id.rgsex);
        chbJava = findViewById(R.id.chb_java);
        chbAndroid = findViewById(R.id.chb_android);
        chbWeb = findViewById(R.id.chb_web);

        Button btnConfirm = findViewById(R.id.btn_confirm);

        imageView.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

        username.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null && imm.isActive()) {
                        imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
                    }
                    return true;
                }
                return false;
            }
        });

        sendFoldNotification();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_header:
                imageView.setImageResource(R.drawable.img);
                break;
            case R.id.btn_confirm:
                String name = username.getText().toString();
                String sex = "";
                int id = rgSex.getCheckedRadioButtonId();
                if (id == R.id.rb_teenager) {
                    sex = "男";
                } else if (id == R.id.rb_lolita) {
                    sex = "女";
                }
                String courses = "";
                if (chbJava.isChecked()) {
                    courses += chbJava.getText().toString() + ",";
                }
                if (chbAndroid.isChecked()) {
                    courses += chbAndroid.getText().toString() + ",";
                }
                if (chbWeb.isChecked()) {
                    courses += chbWeb.getText().toString() + ",";
                }
                courses = courses.substring(0, courses.length() - 1);

                String info = "个人信息：姓名=" + name + ",性别=" + sex + ",喜欢=" + courses;
                Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
                Snackbar.make(v, info, Snackbar.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();

                String location = "触点作标：" + x + "," + y;
                Toast.makeText(InformationActivity.this, location,
                        Toast.LENGTH_SHORT).show();
        }
        return super.onTouchEvent(event);
    }

    public void sendFoldNotification() {
        //1.创建通知
        Notification.Builder builder = null;
        //2.通知操作，定义PendingIntent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "normal";
            NotificationChannel channel = new NotificationChannel(id, "正常通知",
                    NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(channel);
            builder = new Notification.Builder(InformationActivity.this, id);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
        } else {
            builder = new Notification.Builder(InformationActivity.this);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
        }
        //3.通知发送
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_fold);

        Notification notification = builder.build();

        manager.notify(1, builder.build());
    }
}
