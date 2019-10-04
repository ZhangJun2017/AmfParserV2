/**
 * amfparser-parser/Parser.java
 * Description:The exam report parser.
 *
 * @author:ZhangJun2017
 * @date:2019/10/3
 */

package io.zhangjun2017.amfparser.parser;

import flex.messaging.io.ArrayCollection;
import io.zhangjun2017.amfparser.common.Config;
import io.zhangjun2017.amfparser.common.StatusException;

import java.util.ArrayList;


public class Parser {
    private Config originConfig;
    private Config baseInfo = new Config();  //maybe this class won't have base info?
    private ArrayCollection examsCollection;
    private ArrayList<Exam> examArrayList = new ArrayList();

    public Parser(Config config) throws StatusException {
        originConfig = config;
        try {
            parseInit(originConfig);
        } catch (ParseException e) {
            throw new StatusException(-1, "在解析数据时出现了问题", e.toString());
        }
    }

    private void parseInit(Config config) throws ParseException {
        //err stack id 1
        String exceptionMsg1 = "获取所有考试数据时出错，因为\n%s";
        String exceptionMsg2 = "在解析第 %d 次考试时出错，因为\n%s";
        int i = 0;

        //Put every exam into temp
        try {
            examsCollection = (ArrayCollection) config.get("data");  //data may cannot be cast
        } catch (StatusException e) {
            throw new ParseException(String.format(exceptionMsg1, e.toString()));
        }

        //Ask Exam to parse each exam
        try {
            for (i = 0; i < examsCollection.size(); i++) {
                examArrayList.add(new Exam(new Config().put("data", examsCollection.get(i))));
            }
        } catch (ParseException e) {
            throw e.addCause(String.format(exceptionMsg2, examsCollection.size() - i, ""));
        }
    }

    public Exam getExamWithId(int id) {
        return examArrayList.get(id);
    }

    public static void main(String[] args) {
        try {
            ArrayCollection arrayCollection = new ArrayCollection();
            arrayCollection.add("aaaa");
            arrayCollection.add("bbbb");
            System.out.println(new Parser(new Config().put("data", arrayCollection)).examArrayList.get(0).baseInfo.get("233"));
        } catch (StatusException e) {
            System.err.println(e.toString());
        }
    }
}
