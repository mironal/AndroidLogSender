package jp.mironal.java.android.app.logsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LogReceiver extends BroadcastReceiver {

    private static final String EXTRA_NAME_TO = "to"; /* ログの送信先 */
    private static final String EXTRA_NAME_LOG = "log"; /* ログの内容 */

    @Override
    public void onReceive(Context context, Intent intent) {
        // Log.d("LogReceiver", "receive");
        Bundle bundle = intent.getExtras();

        /* ログの送信先を取得 */
        String to = bundle.getString(EXTRA_NAME_TO);
        /* ログの内容を取得 */
        String log = bundle.getString(EXTRA_NAME_LOG);

        /* サービス起動 */
        Intent service = new Intent(context, LogSendService.class);
        service.putExtra(EXTRA_NAME_TO, to);
        service.putExtra(EXTRA_NAME_LOG, log);
        context.startService(service);
    }
}
