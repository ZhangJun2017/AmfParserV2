/**
 * amfparser-parser/Exam.java
 * Description:This class is for parsing each exam
 *
 * @author:ZhangJun2017
 * @date:2019/10/3
 */

package io.zhangjun2017.amfparser.parser;

import flex.messaging.io.ArrayCollection;
import flex.messaging.io.amf.ASObject;
import io.zhangjun2017.amfparser.common.Config;
import io.zhangjun2017.amfparser.common.StatusException;
import io.zhangjun2017.amfparser.common.utils.Tools;

/**
 * Stuff in baseInfo:
 * <p>
 * examName - String
 * rankInClass - int
 * rankInGrade - int     ***messGradeOrder***
 * rankInGrade2 - int    ***   messOrder  ***
 * ***  Note:Since these two seems the same in value,I don't know which is the really "Grade Order"
 * ***  (or is "messOrder" will calculate other score into rank),so both of them will be parsed,you
 * ***  can remind user that their rank has some problems,when the conflict happened.
 * totalScore - double
 * fullScore - double
 * totalStu - int
 * lowestScore - double
 * highestScore - double
 */
public class Exam extends BaseUnit {
    private ASObject origin;
    private ArrayCollection seStudentScoreList;
    private ASObject multiExam;
    private ArrayCollection singleExams;
    private ASObject meStudentScore;


    public Exam(Config config) throws ParseException {
        super(config);
    }

    @Override
    protected BaseUnit init(Config config) throws ParseException {
        String exceptionMsg = "在初始化时出现问题，因为：\n%s";
        try {
            origin = (ASObject) config.get("data");
            seStudentScoreList = (ArrayCollection) new Config().put("data", origin.get("seStudentScoreList")).get("data");  //Being so complex is because Config.get() can throw a StatusException if the data is null
            multiExam = (ASObject) new Config().put("data", origin.get("multiExam")).get("data");
            singleExams = (ArrayCollection) new Config().put("data", origin.get("singleExams")).get("data");
            meStudentScore = (ASObject) new Config().put("data", origin.get("meStudentScore")).get("data");
        } catch (StatusException e) {
            throw new ParseException(String.format(exceptionMsg, e.toString()));
        }
        return this;
    }

    @Override
    protected BaseUnit parse() throws ParseException {
        //TODO:Finish parse method.
        //Parse base info
        this.baseInfo.put("examName", multiExam.get("meName").toString());
        this.baseInfo.put("rankInClass", Integer.parseInt(meStudentScore.get("messClassOrder").toString()));
        this.baseInfo.put("rankInGrade", Integer.parseInt(meStudentScore.get("messGradeOrder").toString()));
        this.baseInfo.put("rankInGrade2", Integer.parseInt(meStudentScore.get("messOrder").toString()));
        this.baseInfo.put("totalScore", Tools.fixNumber(Double.parseDouble(meStudentScore.get("messScore").toString())));
        this.baseInfo.put("fullScore", Tools.fixNumber(Double.parseDouble(multiExam.get("meFullScore").toString())));
        this.baseInfo.put("totalStu", Integer.parseInt(multiExam.get("meStudentCount").toString()));
        this.baseInfo.put("lowestScore", Tools.fixNumber(Double.parseDouble(multiExam.get("meMinScore").toString())));
        this.baseInfo.put("highestScore", Tools.fixNumber(Double.parseDouble(multiExam.get("meMaxScore").toString())));

        //Now let Subject finish his work

        return this;
    }

    public static void main(String[] args) {

    }
}
