import flex.messaging.io.ArrayCollection;
import flex.messaging.io.amf.ASObject;
import flex.messaging.io.amf.client.AMFConnection;
import flex.messaging.io.amf.client.exceptions.ClientStatusException;
import flex.messaging.io.amf.client.exceptions.ServerStatusException;
import io.zhangjun2017.amfparser.common.CallableAsInterface;
import io.zhangjun2017.amfparser.common.Config;
import io.zhangjun2017.amfparser.common.Status;
import io.zhangjun2017.amfparser.common.StatusException;
import io.zhangjun2017.amfparser.common.utils.Tools;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * demo/
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/22
 */

public class ConsoleInterface implements CallableAsInterface {
    public static void main(String[] args) throws StatusException {
        new ConsoleInterface().amfGet(new Config(new ConsoleInterface()).put("url", "http://etreport.iclassmate.cn:8082/SchoolCenter/messagebroker/amf").put("command", "multiExamServiceNew.getAllStudentMultiExam").put("args", new Object[]{19868, "21812140", "token right here,just for debug,do not ban me!"}));
    }

    @Override
    public void output(String s) {
        System.out.print("\n" + s);
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
    public Config amfGet(Config config) throws StatusException {
        try {
            AMFConnection amfConnection = new AMFConnection();
            amfConnection.connect(config.get("url").toString());
            ArrayCollection root = ((ArrayCollection) amfConnection.call(config.get("command").toString(), (Object[]) config.get("args")));
            if (root.size() == 0) {
                throw new StatusException(-3, "Server return null.", "No more details.");
            }
            return new Config().put("data",root);
        } catch (ClientStatusException e) {
            throw new StatusException(-1, "Something bad happened.", e.toString());
        } catch (ServerStatusException e) {
            throw new StatusException(-2, "Something bad happened.", e.toString());
        }
    }

    @Override
    public void throwException(StatusException e) {
        //DEBUG MODE ON
        //RELEASE:System.err.println("[" + e.getErrCode + ":" + e.getUserFriendlyMsg() + "]\n" + e.getMsg());
        //DEBUG:
        e.printStackTrace();
    }

    @Override
    public String demo(CallableAsInterface mInterface) throws StatusException {
        return Tools.parseJson(mInterface.httpGet(Tools.parseJson(mInterface.httpGet(Value.gitee_main_config)).get("prefix").getAsString() + Value.main_suffix)).get("eachVersionConfigServer").getAsString();
    }

    @Override
    public void demo2(CallableAsInterface callableAsInterface) throws StatusException {
        System.err.println(callableAsInterface.httpGet(callableAsInterface.demo(callableAsInterface)));
    }

}
