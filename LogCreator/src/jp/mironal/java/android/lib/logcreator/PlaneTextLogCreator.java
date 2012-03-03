package jp.mironal.java.android.lib.logcreator;

import android.content.Context;

/**
 * 文字列を送るだけ. 全てのメソッドにログレベルの意味はない.
 * 
 * @author mironal
 * 
 */
public class PlaneTextLogCreator {

    /**
     * 初期化を行います.ログを開始する前にこのメソッドを実行しないと、ログが行われません.
     * 
     * @param ctx
     *            コンテキスト.
     */
    public static void Init(Context ctx) {
        LogSender.Init(ctx);
    }

    /**
     * デバッグレベルのログを行います.ログレベルの意味は有りません.
     * 
     * @param msg
     *            ログメッセージ
     */
    public static void d(String msg) {
        LogSender.sendLog(msg);
    }

    /**
     * デバッグレベルのログを行います.ログレベルの意味は有りません.
     * 
     * @param msg
     *            ログメッセージ
     */
    public static void i(String msg) {
        LogSender.sendLog(msg);
    }

    /**
     * デバッグレベルのログを行います.ログレベルの意味は有りません.
     * 
     * @param msg
     *            ログメッセージ
     */
    public static void w(String msg) {
        LogSender.sendLog(msg);
    }

    /**
     * デバッグレベルのログを行います.ログレベルの意味は有りません.
     * 
     * @param msg
     *            ログメッセージ
     */
    public static void e(String msg) {
        LogSender.sendLog(msg);
    }
}
