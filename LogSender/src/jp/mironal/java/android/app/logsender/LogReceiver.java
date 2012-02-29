package jp.mironal.java.android.app.logsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LogReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		//Logの文字列受け取って、サービス起動するだけ.
		Log.d("LogReceiver", "receive");
		Bundle bundle = intent.getExtras();
		String log = bundle.getString("log");
		
		Intent service = new Intent(context,LogSendService.class);
		service.putExtra("log", log);
		context.startService(service);
	}
}
