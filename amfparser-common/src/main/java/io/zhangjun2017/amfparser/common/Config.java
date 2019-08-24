/**
 * amfparser-common/
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/22
 */

package io.zhangjun2017.amfparser.common;

import java.util.HashMap;

public class Config {
    private HashMap<String, Object> configMap = new HashMap<>();
    CallableAsInterface opInterface;

    public Config(CallableAsInterface opInterface) {
        this.opInterface=opInterface;
    }

    public Config() {

    }

    public Object get(String key) {
        return configMap.getOrDefault(key, "数据为空");
    }

    public Config put(String key, Object obj) {
        configMap.put(key, obj);
        return this;
    }
    public void test(){
        opInterface.output("test");
    }
}
