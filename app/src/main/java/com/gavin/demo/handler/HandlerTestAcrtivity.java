package com.gavin.demo.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.gavin.demo.R;

import java.lang.ref.WeakReference;

import javax.xml.validation.Validator;

public class HandlerTestAcrtivity extends AppCompatActivity {
    private static String TAG = "HandlerTestAcrtivity";
    TextView textView;
    MyHandler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        textView = findViewById(R.id.tv);


        handler = new MyHandler(this);
        Message message = Message.obtain();
        message.what = 1;   //消息标识
        message.obj = "AAAA";
        handler.sendMessage(message);   //通过sendMessage方式发送Message

        handler.postDelayed(new Runnable() {    //通过post方式，直接改变UI
            @Override
            public void run() {
                textView.setText("世界更美好!!!");
            }
        },2000);                //延迟2s后，继续改变文字

        String flag = handler.getLooper() == Looper.getMainLooper() ? "true" : "false";
        Log.e(TAG , flag);
        Log.e(TAG , Thread.currentThread() + "");
    }

    private static class MyHandler extends Handler{
        private WeakReference<HandlerTestAcrtivity> mActivty = null;

        private MyHandler(HandlerTestAcrtivity acrtivity) {
            mActivty = new WeakReference<HandlerTestAcrtivity>(acrtivity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HandlerTestAcrtivity acrtivity = mActivty.get();
            switch (msg.what) {
                case 1:
                    String value = msg.obj.toString();
                    acrtivity.textView.setText(value);
                    break;

                default:
                    break;
            }
        }
    }

}
