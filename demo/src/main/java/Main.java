import flex.messaging.io.ArrayCollection;
import io.zhangjun2017.amfparser.common.Config;
import io.zhangjun2017.amfparser.common.StatusException;
import io.zhangjun2017.amfparser.parser.ParseException;
import io.zhangjun2017.amfparser.parser.Parser;

import java.io.Console;
import java.util.HashMap;

/**
 * demo/Main.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/20
 */


public class Main {
    public static void main(String[] args) throws StatusException, ParseException {
        /*ConsoleInterface consoleInterface = new ConsoleInterface();
        try {
            consoleInterface.demo2(consoleInterface);
        } catch (StatusException e) {
            consoleInterface.throwException(e);
        }
        */
        ConsoleInterface consoleInterface = new ConsoleInterface();
        Config stu = new Config();
        stu.put("url", "http://etreport.iclassmate.cn:8081/SchoolCenter/messagebroker/amf").put("command", "multiExamServiceNew.getAllStudentMultiExam").put("args", new Object[]{19868, "21812140", "token right here,just for debug,do not ban me!"});
        Config result = consoleInterface.amfGet(stu);
        Parser parser = new Parser(result);
        System.out.println(parser.getExamWithId(0).baseInfo.toString());
        //new Parser(new Config().put("data",new ConsoleInterface().amfGet(new Config().put("url", "http://etreport.iclassmate.cn:8082/SchoolCenter/messagebroker/amf").put("command", "multiExamServiceNew.getAllStudentMultiExam").put("args", new Object[]{19868, "21812140", "token right here,just for debug,do not ban me!"})))).getExamWithId(0).getRaw();
    }
}
