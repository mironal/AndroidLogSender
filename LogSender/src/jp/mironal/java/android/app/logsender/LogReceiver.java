package jp.mironal.java.android.app.logsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LogReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context ctx, Intent intent) {
        // Log.d("LogReceiver", "receive");

        final String nameTo = ctx.getString(R.string.extra_to);
        final String nameLog = ctx.getString(R.string.extra_log);

        final Bundle bundle = intent.getExtras();

        /* ログの送信先を取得 */
        String extraTo = bundle.getString(nameTo);
        if (extraTo == null) {
            /* ログの送信先が設定されていなかったら、サーバに送る(デフォルトはとりあえずサーバにする). */
            extraTo = ctx.getString(R.string.log_to_server);
        }

        /* ログの内容を取得 */
        String extraLog = bundle.getString(nameLog);
        if (extraLog == null) {
            /* ログが設定されていなかったら何かオカシイので、メッセージを付加 */
            extraLog = ctx.getString(R.string.no_log_msg);
        }

        /* サービス起動 */
        Intent service = new Intent(ctx, LogSendService.class);
        service.putExtra(nameTo, extraTo);
        service.putExtra(nameLog, extraLog);
        ctx.startService(service);
    }
}
