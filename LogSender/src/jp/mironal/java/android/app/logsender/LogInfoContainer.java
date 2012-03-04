package jp.mironal.java.android.app.logsender;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LogInfoContainer {

    private static final String[] LEVEL_TABLE = { "", /* no mapping */
    "", /* reserved */
    "", /* reserved */
    "Debug", "Info", "Warn", "Error", };

    private final Context context;
    private final Bundle bundle;

    public LogInfoContainer(Context ctx, Intent intent) {
        if (ctx == null) {
            throw new NullPointerException("ctx is null.");
        }
        if (intent == null) {
            throw new NullPointerException("intent is null.");
        }
        context = ctx;
        bundle = intent.getExtras();
    }

    /**
     * 指定したIntentにログ情報を付加
     * 
     * @param intent
     *            ログ情報を付加したいIntent.
     */
    public void setExtra(Intent intent) {
        if (intent == null) {
            throw new NullPointerException("intent is null.");
        }

        intent.putExtra(getResString(R.string.extra_time), getTime());
        intent.putExtra(getResString(R.string.extra_tag), getTag());
        intent.putExtra(getResString(R.string.extra_msg), getMsg());
        intent.putExtra(getResString(R.string.extra_level), getLevel());
        intent.putExtra(getResString(R.string.extra_to), getTo());
        intent.putExtra(getResString(R.string.extra_type), getType());
    }

    /**
     * 時刻情報を取得
     * 
     * @return 時刻を示す 文字列
     */
    public String getTime() {
        final String name = getResString(R.string.extra_time);
        final String extra = getExtraIfNullIsEmpty(name);
        return extra;
    }

    /**
     * タグ情報を取得
     * 
     * @return タグの文字列
     */
    public String getTag() {
        final String name = getResString(R.string.extra_tag);
        final String extra = getExtraIfNullIsEmpty(name);
        return extra;
    }

    /**
     * ログのレベルを取得
     * 
     * @return ログレベルを示す文字列.
     */
    public String getLevel() {
        final String name = getResString(R.string.extra_level);
        int num = bundle.getInt(name);
        if (num > LEVEL_TABLE.length) {
            return "";
        }
        return LEVEL_TABLE[num];
    }

    /**
     * ログの送信先を取得
     * 
     * @return ログの送信先を示す文字列.
     */
    public String getTo() {
        final String name = getResString(R.string.extra_to);
        return getExtraIfNullDefault(name, getResString(R.string.log_to_server));
    }

    /**
     * ログフォーマットの種類.
     * 
     * @return 種類を示す文字列
     */
    public String getType() {
        final String name = getResString(R.string.extra_type);
        return getExtraIfNullDefault(name, getResString(R.string.log_type_json));
    }

    /**
     * ログ本文を取得
     * 
     * @return ログの文字列
     */
    public String getMsg() {
        final String name = getResString(R.string.extra_msg);

        return getExtraIfNullDefault(name, getResString(R.string.no_log_msg));
    }

    private String getResString(int resId) {
        return context.getString(resId);
    }

    private String getExtraIfNullDefault(final String name, final String defStr) {
        String extra = bundle.getString(name);
        if (extra == null) {
            return defStr;
        }
        return extra;
    }

    private String getExtraIfNullIsEmpty(final String name) {
        return getExtraIfNullDefault(name, "");
    }

}
