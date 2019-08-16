import flex.messaging.io.amf.client.AMFConnection;
import flex.messaging.io.amf.client.exceptions.ClientStatusException;
import flex.messaging.io.amf.client.exceptions.ServerStatusException;

/**
 * amfparser-common/tobecall.java
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/14
 */

public class tobacall {
    public static void callme() throws ServerStatusException, ClientStatusException {
        System.out.println("I'm from 'tobecall' !");
        System.out.println("v4 test github upload test-190816");
        AMFConnection amfConnection = new AMFConnection();
        amfConnection.connect("http://etreport.iclassmate.cn:8082/SchoolCenter/messagebroker/amf");
        Object result = amfConnection.call("multiExamServiceNew.getAllStudentMultiExam", 19868, "21812140", "Why not check my token???");
        System.out.println(result);
    }

    public static void main(String[] args) throws ServerStatusException, ClientStatusException {
        callme();
    }
}
