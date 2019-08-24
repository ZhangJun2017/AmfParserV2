import io.zhangjun2017.amfparser.common.CallableAsInterface;
import io.zhangjun2017.amfparser.common.Status;
import io.zhangjun2017.amfparser.common.StatusException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * demo/
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/22
 */

public class ConsoleInterface implements CallableAsInterface {
    @Override
    public void output(String s) {
        System.out.println(s);
    }

    @Override
    public void outputNNL(String s) {
        System.out.print(s);
    }

    @Override
    public String getDeviceId() {
        return null;
    }

    @Override
    public Status rawHttpGet(String url) throws StatusException {
        Status toBeReturn = new Status();
        try {
            Response response = new OkHttpClient().newCall(new Request.Builder().url(url).build()).execute();
            return new Status().setStatusCode(response.code()).setStatusMsg(response.body().string());
        } catch (Exception e) {
            throw new StatusException(-1, "Exception happened.", e.toString());
        }
    }

    @Override
    public String httpGet(String url) throws StatusException {
        try {
            Response response = new OkHttpClient().newCall(new Request.Builder().url(url).build()).execute();
            if (response.code() != 200) {
                throw new StatusException(-2, "Response code wrong.", "Server returns " + response.code() + ".");
            }
            return response.body().string();
        } catch (Exception e) {
            throw new StatusException(-1, "Exception happened.", e.toString());
        }
    }

    @Override
    public Status amfGet(String url) {
        return null;
    }

    @Override
    public void throwException(StatusException e) {
        //DEBUG MODE ON
        //RELEASE:System.err.println("[" + e.getUserFriendlyMsg() + "]\n" + e.getMsg());
        //DEBUG:
        e.printStackTrace();
    }
}
