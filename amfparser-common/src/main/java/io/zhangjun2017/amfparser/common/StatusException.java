/**
 * amfparser-common/
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/24
 */

package io.zhangjun2017.amfparser.common;


import java.net.MalformedURLException;
import java.net.URL;

/**
 * How to throw this kind of Exception:
 * System.err.println("[" + e.getErrCode() + ":" + e.getUserFriendlyMsg() + "]\n" + e.getMsg());
 */
public class StatusException extends Exception {
    private int errCode;
    private String userFriendlyMsg;
    private String msg;

    public static void main(String[] args) {
        try {
            URL url = new URL("123");
        } catch (MalformedURLException e) {
            StatusException statusException = new StatusException(233, "bugrighthere!", e.toString());
            System.out.println(e);
        }
    }

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

    @Override
    public String toString() {
        return "[" + this.getErrCode() + ":" + this.getUserFriendlyMsg() + "]" + this.getMsg();
    }
}
