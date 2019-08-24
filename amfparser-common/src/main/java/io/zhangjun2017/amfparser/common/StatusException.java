/**
 * amfparser-common/
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/24
 */

package io.zhangjun2017.amfparser.common;


public class StatusException extends Exception {
    private int errCode;
    private String userFriendlyMsg;
    private String msg;

    public StatusException(int errCode, String userFriendlyMsg, String msg) {
        super(msg);
        this.errCode = errCode;
        this.userFriendlyMsg = userFriendlyMsg;
        this.msg = msg;
    }

    public String getUserFriendlyMsg() {
        return userFriendlyMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getMsg() {
        return msg;
    }
}
