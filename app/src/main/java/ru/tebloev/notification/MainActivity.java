package ru.tebloev.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String FIRST_CHANNEL_NAME = "channel 1";
    public static final String FIRST_CHANNEL_ID = "322";
    public static final String GROUP_ID = "gorup id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(FIRST_CHANNEL_ID,
                    FIRST_CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);

            channel.setDescription("description");
            channel.enableLights(true);
            channel.setGroup(GROUP_ID);
            long[] pattern = {100, 100, 100, 200};
            channel.setVibrationPattern(pattern);
            channel.setImportance(NotificationManager.IMPORTANCE_HIGH);
            channel.setSound(Uri.EMPTY, new AudioAttributes.Builder().build());
            channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            channel.setShowBadge(true);
            channel.setName("name");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, FIRST_CHANNEL_NAME)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
        mBuilder.notify();

    }
}
