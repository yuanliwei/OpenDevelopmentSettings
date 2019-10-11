package com.ylw.opendevelopmentsettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        finish();
        NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this, "ylw")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(false)
                .setColorized(true)
                .setColor(0xff643787)
                .setOngoing(true)
                .setContentTitle("打开开发者选项")
                .setContentText("😜😜😜😂😍😘☺🤩🤣");
        TaskStackBuilder paramBundle = TaskStackBuilder.create(this);
        paramBundle.addNextIntent(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        localBuilder.setContentIntent(paramBundle.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT));
        NotificationManagerCompat.from(this).notify(100, localBuilder.build());
    }
}
