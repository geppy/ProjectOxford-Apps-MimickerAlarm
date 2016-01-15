package com.microsoft.mimicker.ringing;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class AlarmWakeReceiver extends WakefulBroadcastReceiver {

    public final String TAG = this.getClass().getSimpleName();

    // We use a broadcast receiver with the PendingIntent for the AlarmManager, as this approach
    // is more reliable that using a service. See for details: http://hiqes.com/android-alarm-ins-outs/
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Broadcast from AlarmManager received!");
        Intent serviceIntent = new Intent(AlarmRingingService.ACTION_DISPATCH_ALARM);
        serviceIntent.setClass(context, AlarmRingingService.class);
        serviceIntent.putExtras(intent);
        startWakefulService(context, serviceIntent);
    }
}
