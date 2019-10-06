/**
 * amfparser-common/
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/22
 */

package io.zhangjun2017.amfparser.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Config {
    private HashMap<String, Object> configMap = new HashMap<>();
    CallableAsInterface handle;

    public Config(CallableAsInterface handle) {
        this.handle = handle;
    }

    public Config() {
    }

    public Object get(String key) throws StatusException {
        if (configMap.get(key) == null) {
            throw new StatusException(1, "数据为空", "No further details.");
        }
        return configMap.get(key);
    }

    public Config put(String key, Object obj) {
        configMap.put(key, obj);
        return this;
    }

    public CallableAsInterface getHandle() {
        return handle;
    }

    public void test() {
        handle.output("test");
    }

    @Override
    public String toString() {
        ArrayList toReturn = new ArrayList();
        configMap.forEach((a, b) -> toReturn.add(a + " -> " + b + "\n"));
        return toReturn.toString();
    }
}
