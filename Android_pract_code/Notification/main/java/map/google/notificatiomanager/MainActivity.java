package map.google.notificatiomanager;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent();

                PendingIntent pendI = PendingIntent.getActivity
                        (MainActivity.this, 0, i, 0);

                //getActivities(MainActivity, requestCode, intents, flags)
                //requestCode: Private request code for the sender
                //flags:  May be FLAG_ONE_SHOT, FLAG_NO_CREATE, FLAG_CANCEL_CURRENT, FLAG_UPDATE_CURRENT,
                //or any of the flags as supported by
                //Intent.fillIn() to control which unspecified parts of the intent that can
                //be supplied when the actual send happens.


                Notification noti = new Notification.Builder(MainActivity.this)
                        .setTicker("tickerText")
                        .setContentTitle("title")
                        .setContentText("heloo i m yogi..")
                        .setSmallIcon(R.drawable.icon)

                        //.addAction(R.drawable.icon,"Andro",pendI) //addAction(icon, title, intent)
                        //.addAction(R.drawable.icon,"Robo",pendI)

                        .setContentIntent(pendI).getNotification();

                noti.flags = Notification.FLAG_AUTO_CANCEL;

                NotificationManager notiManag = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                notiManag.notify(0, noti);

            }
        });
    }
}