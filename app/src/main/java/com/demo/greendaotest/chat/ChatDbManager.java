package com.demo.greendaotest.chat;

import android.database.sqlite.SQLiteDatabase;

import com.demo.greendaotest.DemoApplication;
import com.demo.greendaotest.chat.dao.Chat;
import com.demo.greendaotest.chat.dao.ChatDao;
import com.demo.greendaotest.chat.dao.DaoMaster;
import com.demo.greendaotest.chat.dao.DaoSession;

import java.util.List;

/**
 * Created by liuwenji on 2018/9/22.
 */

public class ChatDbManager {

    private static final ChatDbManager dbManager = new ChatDbManager();
    private DaoSession daoSession;
    public ChatDbManager () {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(DemoApplication.application, "chat_db",null);
        SQLiteDatabase db = helper.getWritableDatabase();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static ChatDbManager getInstance() {
        return dbManager;
    }

    public long insert(Chat chat) {
        ChatDao chatDao = daoSession.getChatDao();
        long id = chatDao.insertOrReplace(chat);
        return id;
    }

    public void delete(Chat chat) {
        ChatDao chatDao = daoSession.getChatDao();
        chatDao.delete(chat);
    }

    public void update(Chat chat) {
        ChatDao chatDao = daoSession.getChatDao();
        chatDao.update(chat);
    }

    public List<Chat> query() {
        ChatDao chatDao = daoSession.getChatDao();
        return chatDao.queryBuilder().list();
    }
}
