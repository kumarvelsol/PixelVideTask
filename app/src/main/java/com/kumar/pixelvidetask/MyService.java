package com.kumar.pixelvidetask;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyService extends IntentService
{
    public MyService()
    {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        String message = intent.getStringExtra("message");
        intent.setAction(DashBoardActivity.FILTER_ACTION_KEY);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent.putExtra("broadcastMessage", message));
    }
}
