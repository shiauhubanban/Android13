package com.org.iii.shine13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean isStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
