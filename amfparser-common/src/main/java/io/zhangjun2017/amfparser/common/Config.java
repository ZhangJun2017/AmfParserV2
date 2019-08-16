package io.zhangjun2017.amfparser.common;

import java.util.HashMap;

import io.zhangjun2017.amfparser.common.utils.ConfigRule;

/**
 * amfparser-common/Config.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/16
 */

public class Config {

    private HashMap<String, ConfigTypes> configRule;
    private HashMap<String, Object> config = new HashMap<>();

    public Config(HashMap<String, ConfigTypes> rule) {
        configRule = rule;
    }

    public static void initConfig(HashMap<String, ConfigTypes> rule, Config config) {

    }

    private boolean isConfigFormatRight() {
        if (config.isEmpty()) {
            return false;
        }
        config.forEach((key, obj) ->);
    }

    private boolean isTypeValid(String key, Object obj) {
        if (configRule.get(key))
    }

    public void put(String key, Object obj) {

    }
}
