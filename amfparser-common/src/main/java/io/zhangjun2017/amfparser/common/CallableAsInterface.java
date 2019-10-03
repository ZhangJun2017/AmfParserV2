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

    /**
     *
     * @param config ->
     *                 { url:the url to be called
     *                   command:the command defined by amf
     *                   args:the Object[] to be passed to the server
     *                   handler:the interface that can operate
     *                 }
     *
     * @return a Status with code and a HashMap decoded by adobe's library
     */
    Status amfGet(Config config) throws StatusException;

    void throwException(StatusException e);

    String demo(CallableAsInterface mInterface) throws StatusException;

    void demo2(CallableAsInterface mInterface) throws StatusException;
}
