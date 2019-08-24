import io.zhangjun2017.amfparser.common.StatusException;
import io.zhangjun2017.amfparser.common.utils.Tools;


/**
 * demo/Main.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/20
 */

public class Main {
    public static void main(String[] args) {
        try {
            System.err.println(Tools.parseJson(new ConsoleInterface().httpGet(Tools.parseJson(new ConsoleInterface().httpGet(Value.gitee_main_config)).get("prefix").getAsString() + Value.main_suffix)).get("eachVersionConfigServer").getAsString());
        } catch (StatusException e) {
            new ConsoleInterface().throwException(e);
        }
    }
}

class Value {
    final static String gitee_main_config = "https://gitee.com/bugit/API-for-AmfParserV2/raw/master/api/config.json";
    final static String main_suffix = "config.json";
}
