package com.demo.greendao;

import java.io.File;

import de.greenrobot.daogenerator.Schema;

/**
 * Created by liuwenji on 2018/9/22.
 */

public abstract class ParentGenerator {

    public static final String ROOT_DIR = "../app/src/main/java/";
    public static final String DEFAULT_PACKAGE = "com.demo.greendaotest.";
    public static final String GREEN_DAO = "dao";

    public static final String DAO_DIR = "../app/src/main/java/com/demo/greendaotest/";

    public static void clearDir(String model) {
        String clearDir = getClearDir(model);
        File file = new File(clearDir);
        if (file.exists()) {
            file.deleteOnExit();
        }
    }

    public static String createPackage(String model) {//模块名称
        return DEFAULT_PACKAGE + model + "."+ GREEN_DAO;
    }

    public static void setSchema(Schema schema) {
        // 方便在生成的Entity类里自定义代码
        schema.enableKeepSectionsByDefault();
    }

    public static String getClearDir(String model) {
        return DAO_DIR + model + "/" + GREEN_DAO + "/";
    }
}
