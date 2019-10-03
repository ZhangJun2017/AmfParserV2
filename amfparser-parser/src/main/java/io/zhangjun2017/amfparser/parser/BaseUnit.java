/**
 * amfparser-parser/BaseUnit.java
 * Description:This is an abstract class for other items to extend.
 *
 * @author:ZhangJun2017
 * @date:2019/10/3
 */

package io.zhangjun2017.amfparser.parser;

import io.zhangjun2017.amfparser.common.Config;

public abstract class BaseUnit {
    private Config originConfig;
    public Config baseInfo = new Config();  //this is public because I don't want to make more effort so that you can easily change your score :)

    public BaseUnit(Config config) throws ParseException {
        originConfig = config;
        parse(originConfig);
    }

    protected abstract BaseUnit parse(Config config) throws ParseException;

}
