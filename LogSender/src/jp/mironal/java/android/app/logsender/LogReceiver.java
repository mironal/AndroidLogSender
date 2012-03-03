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
        final String extraTo = bundle.getString(nameTo);
        /* ログの内容を取得 */
        final String extraLog = bundle.getString(nameLog);

        /* サービス起動 */
        Intent service = new Intent(ctx, LogSendService.class);
        service.putExtra(nameTo, extraTo);
        service.putExtra(nameLog, extraLog);
        ctx.startService(service);
    }
}
