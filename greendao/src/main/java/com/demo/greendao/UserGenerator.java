package com.demo.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by liuwenji on 2018/9/22.
 */

public class UserGenerator extends ParentGenerator {

    public static final int USER_VISITION = 1;
    public static final String USER = "user";

    //创建user
    public static void buildGenerator() throws Exception {
        clearDir(USER);
        Schema schema = new Schema(USER_VISITION, createPackage(USER));
        setSchema(schema);
        addUserTable(schema);
    }

    private static void addUserTable(Schema schema) throws Exception {
        Entity user = schema.addEntity("User");
        user.setTableName("user");
        user.addLongProperty("id");
        user.implementsSerializable();
        new DaoGenerator().generateAll(schema, ROOT_DIR);
    }
}
