/**
 * amfparser-common/
 * Description:
 *
 * @author:ZhangJun2017
 * @date:2019/8/23
 */

package io.zhangjun2017.amfparser.common.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import io.zhangjun2017.amfparser.common.Status;
import io.zhangjun2017.amfparser.common.StatusException;

public class Tools {
    public static JsonObject parseJson(String json) throws StatusException {
        try {
            JsonElement jsonElement = new JsonParser().parse(json);
            if (jsonElement.isJsonObject()) {
                return jsonElement.getAsJsonObject();
            }
            throw new StatusException(-2, "JsonObject is invalid.", "No more details.");
        } catch (JsonParseException e) {
            throw new StatusException(-1, "JSON is invalid.", e.getMessage());
        }
    }
}
