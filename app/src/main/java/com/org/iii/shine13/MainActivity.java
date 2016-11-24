package com.org.iii.shine13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean isStart;
    private MyReciver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MyReciver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("shine");
        registerReceiver(receiver,filter);
    }

    @Override
    public void finish() {
        super.finish();
        unregisterReceiver(receiver);
    }

    public void startService(View v){
        Intent it = new Intent(this,MyService.class);
        it.putExtra("isstart", isStart);
        it.putExtra("value", (int)(Math.random()*100) + 1);
        startService(it);
        isStart = true;
    }
    public void stopService(View v){
        Intent it = new Intent(this,MyService.class);
        stopService(it);
    }
    private class MyReciver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v("shine","got it");
        }
    }
}
