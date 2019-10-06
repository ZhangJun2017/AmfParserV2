/**
 * amfparser-parser/Subject.java
 * Description:This class is for parsing each subject in each exam
 *
 * @author:ZhangJun2017
 * @date:2019/10/4
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
 * subjectName - String
 * ***  Note:We'll give you "seName",which contents exam name,but also within other useful information,
 * ***  you should cut off those unnecessariness.
 * courseName - String
 * ***  Note:The simple form of "subjectName",if there's two same "courseName",there must be something wrong,
 * ***  warn your users!
 * rankInClass - int
 * rankInGrade - int     ***essGradeOrder***
 * rankInGrade2 - int    ***   essOrder  ***
 * ***  Note:So strange that each subject also has two "Class Rank",see more at Exam.java
 * subjectScore - double
 * objectScore - double
 * score - double
 * fullScore - double
 * totalStu - int
 * lowestScore - double
 * highestScore - double
 */
public class Subject extends BaseUnit {
    private ASObject originSingleExams;
    private ASObject originSeStudentScoreList;

    public Subject(Config config) throws ParseException {
        super(config);
    }

    @Override
    protected BaseUnit init(Config config) throws ParseException {
        String exceptionMsg = "在初始化时出现问题，因为：\n%s";
        try {
            originSingleExams = (ASObject) config.get("data1");
            originSeStudentScoreList = (ASObject) config.get("data2");
        } catch (StatusException e) {
            throw new ParseException(String.format(exceptionMsg, e.toString()));
        }
        return this;
    }

    @Override
    protected BaseUnit parse() throws ParseException {
        //TODO:Finish parse method.
        //Parse base info
        this.baseInfo.put("subjectName", originSingleExams.get("seName").toString());
        this.baseInfo.put("courseName", originSingleExams.get("seCourseName").toString());
        this.baseInfo.put("rankInClass", Integer.parseInt(originSeStudentScoreList.get("essClassOrder").toString()));
        this.baseInfo.put("rankInGrade", Integer.parseInt(originSeStudentScoreList.get("essGradeOrder").toString()));
        this.baseInfo.put("rankInGrade2", Integer.parseInt(originSeStudentScoreList.get("essOrder").toString()));
        this.baseInfo.put("subjectScore", Tools.fixNumber(Double.parseDouble(originSeStudentScoreList.get("subjectScore").toString())));
        this.baseInfo.put("objectScore", Tools.fixNumber(Double.parseDouble(originSeStudentScoreList.get("objectScore").toString())));
        this.baseInfo.put("Score", Tools.fixNumber(Double.parseDouble(originSeStudentScoreList.get("essScore").toString())));
        this.baseInfo.put("fullScore", Tools.fixNumber(Double.parseDouble(originSingleExams.get("seFullScore").toString())));
        this.baseInfo.put("totalStu", Integer.parseInt(originSeStudentScoreList.get("seStudentCount").toString()));
        this.baseInfo.put("lowestScore", Tools.fixNumber(Double.parseDouble(originSingleExams.get("seMinScore").toString())));
        this.baseInfo.put("highestScore", Tools.fixNumber(Double.parseDouble(originSingleExams.get("seMaxScore").toString())));
        return this;
    }
}
