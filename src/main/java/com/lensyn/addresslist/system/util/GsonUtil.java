package com.lensyn.addresslist.system.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by lizhongfu on 10:02 2017/12/18
 */
public class GsonUtil {
    private GsonUtil() {
    }

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();

    public static Gson getGson() {
        return gson;
    }
}
