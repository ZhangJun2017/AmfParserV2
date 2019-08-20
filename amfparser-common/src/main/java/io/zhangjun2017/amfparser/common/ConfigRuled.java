package io.zhangjun2017.amfparser.common;

import java.util.HashMap;
import java.util.Set;

import io.zhangjun2017.amfparser.common.utils.ConfigRule;

/**
 * amfparser-common/ConfigRuled.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/16
 */

@Deprecated
public class ConfigRuled {

    private ConfigRule configRule = new ConfigRule();
    private HashMap<String, Object> config = new HashMap<>();
    private boolean NO_RULE_MODE = false;

    public ConfigRuled(ConfigRule rule) {
        configRule = rule;
    }

    public ConfigRuled(boolean noRuleMode) {
        NO_RULE_MODE = true;
    }

    public ConfigRule getRule() {
        return configRule;
    }

    public void put(String key, Object obj) {
        if (!NO_RULE_MODE) {
            config.put(key, obj);
            if (!ConfigRule.isKeyFollowRule(this, key)) {
                config.remove(key);
                System.err.println("WARNING:INPUT FORMAT WRONG!");
            }
        }
    }

    public Object get(String key) {
        return config.get(key);
    }

    public Set<String> getKeySet() {
        return config.keySet();
    }

    public int size() {
        return configRule.size();
    }

}
