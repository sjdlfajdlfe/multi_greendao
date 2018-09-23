package com.demo.greendaotest.chat;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.demo.greendaotest.R;
import com.demo.greendaotest.chat.dao.Chat;

import java.util.List;

/**
 * Created by liuwenji on 2018/9/22.
 */

public class ChatProcessActivity extends Activity {

    private String TAG = ChatProcessActivity.class.getSimpleName();
    TextView insert_tv;
    TextView delete_tv;
    TextView update_tv;
    TextView query_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        insert_tv = (TextView) findViewById(R.id.insert);
        delete_tv = (TextView) findViewById(R.id.delete);
        update_tv = (TextView) findViewById(R.id.update);
        query_tv = (TextView) findViewById(R.id.query);
        insert_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chat chat = new Chat();
                chat.setId(System.currentTimeMillis());
                long id = ChatDbManager.getInstance().insert(chat);
                Log.d(TAG," insert id= " + id);
            }
        });

        delete_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ChatDbManager.getInstance().delete();
            }
        });

        update_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ChatDbManager.getInstance().update();
            }
        });

        query_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Chat> chats = ChatDbManager.getInstance().query();
                Log.d(TAG,"query size= " + chats.size());
            }
        });
    }

}
