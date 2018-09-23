package com.demo.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by liuwenji on 2018/9/22.
 */

public class GreenDaoGeneratorManager {

    public static void main(String[] args) throws Exception {
        UserGenerator.buildGenerator();
        ChatGenerator.buildGenerator();
    }
}
