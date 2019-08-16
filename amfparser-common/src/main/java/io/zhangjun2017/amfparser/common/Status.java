package io.zhangjun2017.amfparser.common;

/**
 * amfparser-common/Status.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/16
 */

public class Status {
    private int code;
    private String msg;
    private Object extra = null;

    public Status(int code, String msg, Object extra) {
        this.code = code;
        this.msg = msg;
        this.extra = extra;
    }

    public Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getStatusCode() {
        return code;
    }

    public void setStatusCode(int code) {
        this.code = code;
    }

    public String getStatusMsg() {
        return msg;
    }

    public void setStatusMsg(String msg) {
        this.msg = msg;
    }

    public Object getStatusExtra() {
        return extra;
    }

    public void setStatusExtra(Object extra) {
        this.extra = extra;
    }
}
