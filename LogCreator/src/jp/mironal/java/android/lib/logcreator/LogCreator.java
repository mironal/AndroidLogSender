package jp.mironal.java.android.lib.logcreator;

import android.content.Context;

public class LogCreator {

    /**
     * 初期化を行います.ログを開始する前にこのメソッドを実行しないと、ログが行われません.
     * 
     * @param ctx
     *            コンテキスト.
     */
    public static void Init(Context ctx) {
        LogSender.Init(ctx);
    }

    public static void d(String tag, String msg) {
        LogInfoBuilder builder = new LogInfoBuilder();
        builder.setCurrentTime().setMsg(msg).setTag(tag)
                .setLevel(LogInfoBuilder.LEVEL_D);

        LogSender.sendLog(builder);
    }

    public static void i(String tag, String msg) {

    }

    public static void w(String tag, String msg) {

    }

    public static void e(String tag, String msg) {

    }

}
