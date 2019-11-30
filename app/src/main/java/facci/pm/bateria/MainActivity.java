package facci.pm.bateria;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView mBatteryLevelText;
    private ProgressBar mBatteryLevelProgress;
    private BroadcastReceiver mReceiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBatteryLevelText = findViewById(R.id.textView);
        mBatteryLevelProgress = findViewById(R.id.progressBar);
         mReceiver = new BatteryBroadcastReceiver();
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        Log.e("4C", "OnStart");
    }
    private class BatteryBroadcastReceiver extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,
                     0);
            mBatteryLevelText.setText(
                    level + ""+ getString(R.string.nivel_de_bateria));
            mBatteryLevelProgress.setProgress(level);


        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("4C", "OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("4C", "OnRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("4C", "OnPause");

        if (isDestroyed())
        {
            Log.e("4C", "Destruida");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mReceiver);

        Log.e("4C", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("4C", "OnDestroy");
    }



    }


