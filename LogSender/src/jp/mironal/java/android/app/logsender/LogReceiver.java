package jp.mironal.java.android.app.logsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LogReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context ctx, Intent intent) {
        //Log.d("LogReceiver", "receive");
         
        LogInfoContainer infoContainer = new LogInfoContainer(ctx, intent);

        /* サービス起動 */
        Intent service = new Intent(ctx, LogSendService.class);
        infoContainer.setExtra(service);

        ctx.startService(service);
    }
}
