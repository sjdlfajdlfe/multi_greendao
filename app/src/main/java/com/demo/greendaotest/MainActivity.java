package com.demo.greendaotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.greendaotest.chat.ChatDbManager;
import com.demo.greendaotest.chat.ChatProcessActivity;
import com.demo.greendaotest.chat.dao.Chat;

public class MainActivity extends AppCompatActivity {

    TextView jump_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jump_tv = findViewById(R.id.jump_tv);
        jump_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ChatProcessActivity.class));
            }
        });
        for (int i = 0; i < 5 ; i++) {
            Chat chat = new Chat();
            chat.setId(System.currentTimeMillis());
            ChatDbManager.getInstance().insert(chat);
        }

    }
}
