/**
 * amfparser-common/ConfigRule.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/16
 */

package io.zhangjun2017.amfparser.common.utils;

import io.zhangjun2017.amfparser.common.ConfigRuled;

import java.util.HashMap;

@Deprecated
public class ConfigRule {
    private HashMap<String, ConfigType> configRule = new HashMap<>();

    public ConfigRule() {
    }

    /**
     * @param config Config that to be check.
     * @return is Config valid to specified rule.
     * <p>
     * A ConfigRule should be a HashMap,which contain the 'name' of Config's key,and the type it should be.
     * The type is an enum-type,it allowed 'STRING' and 'INT'.
     */
    public static boolean isConfigFollowRule(ConfigRuled config) {
        ConfigRule rule = config.getRule();
        if (config.size() != rule.size()) {
            return false;
        }
        for (String name : config.getKeySet()) {
            if (!isKeyFollowRule(config, name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param config Config that contains the key which to be check.
     * @param which  Which key to check.
     * @return Is 'which' follow the rule of this 'config'.
     */
    public static boolean isKeyFollowRule(ConfigRuled config, String which) {
        if (!(ConfigType.isBelongTo(config.get(which), config.getRule().get(which)))) {
            return false;
        }
        return true;
    }

    public void add(String name, ConfigType type) {
        configRule.put(name, type);
    }

    public ConfigType get(String name) {
        return configRule.getOrDefault(name, ConfigType.NULL);
    }

    public int size() {
        return configRule.size();
    }

}
