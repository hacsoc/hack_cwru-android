package org.hacsoc.hackcwru.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Util functions for JSON things like serialization.
 *
 * Created by andrew on 6/10/15.
 */
public class JSONUtil {
    /**
     * Serialize a JSON object to a form-encoded string. Recurses on nested
     * object definitions (JSONObjects that are composed of JSONObjects).
     *
     * If the JSON object looks like:
     * {
     *     "key1": 4,
     *     "key2": "foo"
     * }
     * Then the resulting string will be: "\"key1\"=4,\"key2\"=\"foo\"".
     *
     * @param jsonObject The JSONObject to serialize.
     * @return
     */
    public static String serialize(JSONObject jsonObject) {
        return serialize(jsonObject, null);
    }

    /**
     * Serialize a JSON object to a form-encoded string, given a context. Adding
     * a context causes the serialization to correctly encode for nested structures.
     *
     * For example, given the JSON object: {"key1": 4}, and the context "object",
     * the serialized string will be: "object[\"key1\"]=4".
     *
     * The function recurses on any nested JSONObjects in the jsonObject and updates
     * the context appropriately to the recursive call. For example, given the JSON object:
     * {"user": {"id": 1}}, and the context "bar", on the first recursion, the new context
     * will be set to "bar[\"user\"]", so the final string would be "bar[\"user\"][\"id\"]=1".
     *
     * @param jsonObject The JSONObject to serialize.
     * @param context Any context to serialize with respect to. See the above
     *                examples for how this works.
     * @return
     */
    public static String serialize(JSONObject jsonObject, String context) {
        StringBuilder json = new StringBuilder();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object data = null;
            try {
                data = jsonObject.get(key);
            } catch (JSONException e) {}
            if (data != null) {
                String innerContext, value;
                if (context == null) {
                    innerContext = key;
                } else {
                    innerContext = String.format("%s[%s]", context, key);
                }
                if (data instanceof JSONObject) {
                    value = serialize((JSONObject) data, innerContext);
                } else {
                    value = String.format("%s=%s", innerContext, data.toString());
                }
                json.append(value);
                if (keys.hasNext()) {
                    json.append(',');
                }
            }
        }
        return json.toString();
    }
}
