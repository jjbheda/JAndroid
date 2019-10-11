package com.gavin.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gavin.demo.handler.HandlerTestAcrtivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_handler_a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_handler_a = findViewById(R.id.tv_handler_a);
        tv_handler_a.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_handler_a) {
            Intent intent = new Intent(MainActivity.this, HandlerTestAcrtivity.class);
            startActivity(intent);
        }
    }
}
