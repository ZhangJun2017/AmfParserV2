/**
 * amfparser-parser/Exam.java
 * Description:This class is for parsing each exam
 *
 * @author:ZhangJun2017
 * @date:2019/10/3
 */

package io.zhangjun2017.amfparser.parser;

import io.zhangjun2017.amfparser.common.Config;
import io.zhangjun2017.amfparser.common.StatusException;

public class Exam extends BaseUnit {
    public Exam(Config config) throws ParseException {
        super(config);
    }

    @Override
    protected BaseUnit parse(Config config) throws ParseException {
        //TODO:Finish parse method.
        try {
            if (config.get("data").equals("bbbb")) {
                throw new ParseException("What the fuck?");
            }
        } catch (StatusException e) {
            e.printStackTrace();
        }
        return this;
    }
}
