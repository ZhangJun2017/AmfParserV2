import io.zhangjun2017.amfparser.common.StatusException;

/**
 * demo/Main.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/20
 */


public class Main {
    public static void main(String[] args) {
        ConsoleInterface consoleInterface = new ConsoleInterface();
        try {
            consoleInterface.demo2(consoleInterface);
        } catch (StatusException e) {
            consoleInterface.throwException(e);
        }
    }
}
