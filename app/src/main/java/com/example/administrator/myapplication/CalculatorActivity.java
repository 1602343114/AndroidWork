package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

public class CalculatorActivity extends AppCompatActivity {
    private TextView tv_result;
    private TextView tv_fomula;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        tv_result = findViewById(R.id.result);
        tv_fomula = findViewById(R.id.fomula);
        text = "";
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
            case R.id.add:
            case R.id.sub:
            case R.id.mul:
            case R.id.div:
                Button btn = (Button) view;
                text = btn.getText().toString();
                tv_fomula.setText(tv_fomula.getText().toString() + text);
                break;
            case R.id.c:
                tv_fomula.setText("");
                tv_result.setText("");
                break;
            case R.id.delete:
                text = tv_fomula.getText().toString();
                if (text.length() >= 1) {
                    tv_fomula.setText(text.substring(0, text.length() - 1));
                }
                break;
            case R.id.equal:
                String regex = "^(-)?\\d+(.\\d+)?[+\\-*/]\\d+(.d+)?";

                text = tv_fomula.getText().toString();
                if (!TextUtils.isEmpty(text) && text.matches(regex)) {
                    try {
                        Symbols symbol = new Symbols();
                        System.out.println(text);
                        double res = symbol.eval(text);
                        tv_result.setText(String.valueOf(res));
                    } catch (SyntaxException e) {
                        e.printStackTrace();
                        Toast.makeText(this, text + "语法错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, text + "不是合法的", Toast.LENGTH_SHORT).show();
                }
                text = "";
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        String fomula = tv_fomula.getText().toString();
        String data = tv_result.getText().toString();

        outState.putString("tv_fomula", fomula);
        outState.putString("tv_result", data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}
