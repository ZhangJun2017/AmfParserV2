/**
 * amfparser-parser/ParseException.java
 * Description:For describing the exception happened when parsing.
 *
 * @author:ZhangJun2017
 * @date:2019/10/3
 */

package io.zhangjun2017.amfparser.parser;

import java.util.ArrayList;

public class ParseException extends Throwable {

    private ArrayList<String> exceptionsList = new ArrayList<>();

    public ParseException(String initLine) {
        super();
        exceptionsList.add(initLine);
    }

    public ParseException addCause(String msg) {
        exceptionsList.add(msg);
        return this;
    }

    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < exceptionsList.size(); i++) {
            list = list + exceptionsList.get(exceptionsList.size() - 1 - i);
        }
        return list;
    }
}
