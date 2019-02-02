package com.ftninformatika.termin18radnacasu;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnToast;
    Button btnSnack;
    Button btnObavestenje;
    Button btnSettings;

    public static final int NOTIFICATION_ID = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSnack = findViewById(R.id.button2);
        btnToast = findViewById(R.id.button);
        btnSettings = findViewById(R.id.btnSettings);
        btnObavestenje = findViewById(R.id.button3);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ovo je Toast", Toast.LENGTH_SHORT).show();
            }
        });

        btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(MainActivity.this.findViewById(R.id.parent), "Ovo je snackbar", Snackbar.LENGTH_SHORT).show();

            }
        });
        btnObavestenje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prikaziObavestenje();
            }
        });


        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Preferenc_activity.class);
                startActivity(intent);
            }
        });

    }


    private void prikaziObavestenje(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("Ovo je naslov");
        builder.setContentText("Ovo je tekst obavestenja i moze biti proizvoljno dugacak");
        builder.setSmallIcon(R.drawable.ic_stat_buy);
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());

    }

}
