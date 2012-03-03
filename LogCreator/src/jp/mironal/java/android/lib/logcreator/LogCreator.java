package jp.mironal.java.android.lib.logcreator;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class LogCreator {

    private static boolean IS_LOG_ENABLE = false;

    private static final String ACTION = "jp.mironal.java.android.app.logsender.receiver.LOG";
    private static final String EXTRA_NAME = "log";

    private static Context context;

    public static void Init(Context ctx) {
        if (ctx == null) {
            throw new NullPointerException("ctx is null.");
        }
        context = ctx;
        IS_LOG_ENABLE = checkDebuggable(ctx);
    }

    /**
     * マニフェストファイルからデバッグモードかどうか取得
     * 
     * @param ctx
     *            コンテキスト
     * @return true:デバッグモード.
     */
    private static boolean checkDebuggable(Context ctx) {
        PackageManager pkgMan = ctx.getPackageManager();
        ApplicationInfo appInfo = null;
        try {
            appInfo = pkgMan.getApplicationInfo(ctx.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            return false;
        }
        if ((appInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) == ApplicationInfo.FLAG_DEBUGGABLE) {
            return true;
        }
        return false;
    }

    public static void d(String tag, String msg) {

    }

    public static void i(String tag, String msg) {

    }

    public static void w(String tag, String msg) {

    }

    public static void e(String tag, String msg) {

    }

    private static void sendLog(String log) {
        /* 異常時は即リターン */
        if ((log == null) || (context == null)) {
            return;
        }
        /* intentを飛ばす */
        if (IS_LOG_ENABLE) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(EXTRA_NAME, log);
            context.sendBroadcast(intent);
        }
    }

}
