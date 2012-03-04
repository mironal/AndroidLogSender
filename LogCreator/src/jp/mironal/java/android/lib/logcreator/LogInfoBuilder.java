package jp.mironal.java.android.lib.logcreator;

import java.util.HashMap;
import java.util.Map.Entry;

import android.content.Intent;

class LogInfoBuilder {

    public static final String KEY_TIME = "time";
    public static final String KEY_TAG = "tag";
    public static final String KEY_MSG = "msg";
    public static final String KEY_LEVEL = "level";
    public static final String KEY_TO = "to";
    public static final String KEY_TYPE = "type";

    public static final int LEVEL_D = 3;
    public static final int LEVEL_I = 4;
    public static final int LEVEL_W = 5;
    public static final int LEVEL_E = 6;

    private final HashMap<String, String> infoMap = new HashMap<String, String>();

    public LogInfoBuilder addInfo(String key, String val) {
        infoMap.put(key, val);
        return this;
    }

    public Intent buildIntent(String action) {
        Intent intent = new Intent(action);
        for (Entry<String, String> e : infoMap.entrySet()) {
            intent.putExtra(e.getKey(), e.getValue());
        }
        return intent;
    }

    public LogInfoBuilder setLevel(int level) {
        infoMap.put(KEY_LEVEL, String.valueOf(level));
        return this;
    }

    public LogInfoBuilder setTag(String tag) {
        infoMap.put(KEY_TAG, tag);
        return this;
    }

    public LogInfoBuilder setCurrentTime() {
        infoMap.put(KEY_TIME, "0");
        return this;
    }

    public LogInfoBuilder setMsg(String msg) {
        infoMap.put(KEY_MSG, msg);
        return this;
    }

    public LogInfoBuilder setTo(String to) {
        infoMap.put(KEY_TO, to);
        return this;
    }

    public LogInfoBuilder setType(String type) {
        infoMap.put(KEY_TYPE, type);
        return this;
    }

}
