package com.example.backgroundtask;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.SystemClock;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;


public class myBackgroundProcess extends BroadcastReceiver {




    @Override
    public void onReceive(Context context, Intent intent) {

      Ringtone ringtone = RingtoneManager.getRingtone(context,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        ringtone.play();

        Toast.makeText(context, "This is my background process: \n" + Calendar.getInstance().getTime().toString(), Toast.LENGTH_LONG).show();


        SystemClock.sleep(0);
        ringtone.stop();

    }
}
