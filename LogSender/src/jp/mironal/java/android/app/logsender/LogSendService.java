package jp.mironal.java.android.app.logsender;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

public class LogSendService extends Service {

	private static final String TAG = "LogSendService";
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		
		Log.d(TAG, "start service");
		
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
		
		Bundle bundle = intent.getExtras();
		String log = bundle.getString("log");

		String ip = pref.getString("ip", "192.168.0.1");
		String portStr = pref.getString("port", "9999");
		int port = Integer.parseInt(portStr);
		
		Log.d(TAG, "ip = " + ip + " port = " + port);
		
		try{
			Log.d(TAG,"start client");
			Socket sock = new Socket(ip, port);

			OutputStream out = sock.getOutputStream();
			PrintWriter pw = new PrintWriter(out);
			pw.print(log);
			pw.flush();
			sock.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		
		return null;
	}

}
