package jp.mironal.java.android.app.testlogsender;

import jp.mironal.java.android.lib.logcreator.LogCreator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TestLogSenderActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        for (int i = 0; i < 10; i++) {
            Intent intent = new Intent(
                    "jp.mironal.java.android.app.logsender.receiver.LOG");
            intent.putExtra("msg", "logloglgo" + System.currentTimeMillis());
            sendBroadcast(intent);
        }
        
        
        finish();
    }

}