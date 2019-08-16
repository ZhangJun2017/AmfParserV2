package io.zhangjun2017.amfparser.common;

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

    Status httpGet(String url);

    Status amfGet(String url);
}
