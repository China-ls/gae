package weixin.popular.util;

import com.google.gson.Gson;

public class JsonUtil {

    private static Gson gson = new Gson();

    private JsonUtil() {
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static String toJSONString(Object object) {
        return gson.toJson(object);
    }
}
