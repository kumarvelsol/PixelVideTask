package com.kumar.pixelvidetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class DashBoardActivity extends AppCompatActivity {
    String userNameFromLogin;
    TextView mLabelUSerName;
    MyReceiver myReceiver;
    public static final String FILTER_ACTION_KEY = "any_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        mLabelUSerName=(TextView)findViewById(R.id.dash_board_label_user_name) ;
        userNameFromLogin= getIntent().getExtras().getString("login_user_name");

        Intent intent = new Intent(DashBoardActivity.this, MyService.class);
        intent.putExtra("message", userNameFromLogin);
        startService(intent);

    }

    private void setReceiver()
    {
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(FILTER_ACTION_KEY);
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStart()
    {
        setReceiver();
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(myReceiver);
        super.onStop();
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("broadcastMessage");
            mLabelUSerName.setText(message);
        }
    }
}
