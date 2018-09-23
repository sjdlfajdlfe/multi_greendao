package com.demo.greendaotest.chat.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.demo.greendaotest.chat.dao.Chat;
import com.demo.greendaotest.chat.dao.ChatGroup;

import com.demo.greendaotest.chat.dao.ChatDao;
import com.demo.greendaotest.chat.dao.ChatGroupDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig chatDaoConfig;
    private final DaoConfig chatGroupDaoConfig;

    private final ChatDao chatDao;
    private final ChatGroupDao chatGroupDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        chatDaoConfig = daoConfigMap.get(ChatDao.class).clone();
        chatDaoConfig.initIdentityScope(type);

        chatGroupDaoConfig = daoConfigMap.get(ChatGroupDao.class).clone();
        chatGroupDaoConfig.initIdentityScope(type);

        chatDao = new ChatDao(chatDaoConfig, this);
        chatGroupDao = new ChatGroupDao(chatGroupDaoConfig, this);

        registerDao(Chat.class, chatDao);
        registerDao(ChatGroup.class, chatGroupDao);
    }
    
    public void clear() {
        chatDaoConfig.getIdentityScope().clear();
        chatGroupDaoConfig.getIdentityScope().clear();
    }

    public ChatDao getChatDao() {
        return chatDao;
    }

    public ChatGroupDao getChatGroupDao() {
        return chatGroupDao;
    }

}