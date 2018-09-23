package com.demo.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by liuwenji on 2018/9/22.
 */

public class ChatGenerator extends ParentGenerator {

    public static final int CHAT_VISITION = 1;
    public static final String CHAT = "chat";

    public static void buildGenerator() throws Exception {
        clearDir(CHAT);
        Schema schema = new Schema(CHAT_VISITION, createPackage(CHAT));
        setSchema(schema);
        addChatTable(schema);
        addChatGroupTable(schema);
    }

    private static void addChatTable(Schema schema) throws Exception {
        Entity chat = schema.addEntity("Chat");
        chat.setTableName("chat");
        chat.addLongProperty("id");
        chat.implementsSerializable();
        new DaoGenerator().generateAll(schema, ROOT_DIR);
    }

    private static void addChatGroupTable(Schema schema) throws Exception {
        Entity chat = schema.addEntity("ChatGroup");
        chat.setTableName("chat_group");
        chat.addLongProperty("id");
        chat.implementsSerializable();
        new DaoGenerator().generateAll(schema, ROOT_DIR);
    }
}
