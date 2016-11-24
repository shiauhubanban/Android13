package com.org.iii.shine13;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;
    private int i ;


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        timer.schedule(new MyTask(),1000,1000);
        //Log.v("shine","onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean isStart = intent.getBooleanExtra("isstart",false);
        if (isStart){
            i = intent.getIntExtra("value",-100);
        }

        //Log.v("shine","onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer !=null){
            timer.purge(); //清掉
            timer.cancel();
            timer = null; //清除記憶體
        }
        //Log.v("shine","onDestroy()");
    }
    private class MyTask extends TimerTask{
        @Override
        public void run() {
            Log.v("shine","i="+i ++);
            Intent it = new Intent("shine");
            sendBroadcast(it);
        }
    }
}
