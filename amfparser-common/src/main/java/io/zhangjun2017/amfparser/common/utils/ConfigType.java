/**
 * amfparser-common/ConfigType.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/16
 */

package io.zhangjun2017.amfparser.common.utils;

@Deprecated
public enum ConfigType {
    STRING(), INT(), NULL();

    public static boolean isBelongTo(Object toCheck, ConfigType which) {
        if (which == STRING) {
            if (toCheck.getClass() == new String("").getClass()) return true;
        } else if (which == INT) {
            if (toCheck.getClass() == new Integer("").getClass()) return true;
        }
        return false;
    }
}
