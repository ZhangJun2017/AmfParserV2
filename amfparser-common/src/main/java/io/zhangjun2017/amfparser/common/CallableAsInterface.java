package io.zhangjun2017.amfparser.common;

import java.io.IOError;
import java.io.IOException;

/**
 * amfparser-common/CallableAsInterface.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/16
 */

public interface CallableAsInterface {
    void output(String str);

    void outputNNL(String str);

    String getDeviceId();

    String httpGet(String url) throws StatusException;

    Status rawHttpGet(String url) throws StatusException;

    Status amfGet(String url);

    void throwException(StatusException e);
}
