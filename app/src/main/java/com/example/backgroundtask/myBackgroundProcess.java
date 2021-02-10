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

import static com.example.backgroundtask.MainActivity.NOTIFICATION_CHANNEL_ID;

public class myBackgroundProcess extends BroadcastReceiver {

    public static String NOTIFICATION_ID = "notification-id" ;
    public static String NOTIFICATION = "notification" ;


    @Override
    public void onReceive(Context context, Intent intent) {

      Ringtone ringtone = RingtoneManager.getRingtone(context,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        ringtone.play();

        Toast.makeText(context, "This is my background process: \n" + Calendar.getInstance().getTime().toString(), Toast.LENGTH_LONG).show();


     NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context. NOTIFICATION_SERVICE ) ;
        Notification notification = intent.getParcelableExtra( NOTIFICATION ) ;
        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
            int importance = NotificationManager. IMPORTANCE_HIGH ;
            NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel) ;
        }
        int id = intent.getIntExtra( NOTIFICATION_ID , 0 ) ;
        assert notificationManager != null;
        notificationManager.notify(id , notification) ;


        SystemClock.sleep(0);
        ringtone.stop();

    }
}
