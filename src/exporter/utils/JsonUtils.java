package exporter.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {
    public static int getInt(JSONObject jsonObject, String field, int def) throws JSONException {
        Object object = jsonObject.get(field);
        if (object instanceof Number) {
            return ((Number) object).intValue();
        } else if (object instanceof String && !((String) object).isEmpty()) {
            return Integer.parseInt((String) object);
        } else {
            return def;
        }
    }

    public static double getDouble(JSONObject jsonObject, String field, double def) throws JSONException {
        Object object = jsonObject.get(field);
        if (object instanceof Number) {
            return ((Number) object).doubleValue();
        } else if (object instanceof String && !((String) object).isEmpty()) {
            return Double.parseDouble((String) object);
        } else {
            return def;
        }
    }

    public static String getString(JSONObject jsonObject, String field) throws JSONException {
        return getString(jsonObject, field, null);
    }

    public static String getString(JSONObject jsonObject, String field, String def) throws JSONException {
        if (jsonObject.has(field)) {
            return jsonObject.getString(field);
        } else {
            return def;
        }
    }
}
