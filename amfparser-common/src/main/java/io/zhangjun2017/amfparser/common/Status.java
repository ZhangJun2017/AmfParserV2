/**
 * amfparser-common/Status.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/16
 */

package io.zhangjun2017.amfparser.common;

public class Status {
    private int code;
    private String msg;
    private Object extra = null;

    public Status() {
    }

    public int getStatusCode() {
        return code;
    }

    public Status setStatusCode(int code) {
        this.code = code;
        return this;
    }

    public String getStatusMsg() {
        return msg;
    }

    public Status setStatusMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getStatusExtra() {
        return extra;
    }

    public Status setStatusExtra(Object extra) {
        this.extra = extra;
        return this;
    }
}
