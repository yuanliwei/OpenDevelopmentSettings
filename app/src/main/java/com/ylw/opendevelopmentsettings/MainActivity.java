package com.ylw.opendevelopmentsettings;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        finish();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("ylw", "ylw", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("ylw");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this, "ylw")
                .setSmallIcon(R.drawable.ic_action)
                .setAutoCancel(false)
                .setSilent(true)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setColorized(true)
                .setColor(0xff643787)
                .setOngoing(true)
                .setContentTitle("打开开发者选项")
                .setContentText("😜😜😜😂😍😘☺🤩🤣");
        TaskStackBuilder intentBuilder = TaskStackBuilder.create(this);
        intentBuilder.addNextIntent(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        localBuilder.setContentIntent(intentBuilder.getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE));
        NotificationManagerCompat.from(this).notify(100, localBuilder.build());
    }
}
