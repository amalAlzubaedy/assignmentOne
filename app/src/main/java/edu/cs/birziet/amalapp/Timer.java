package edu.cs.birziet.amalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Timer extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        textView=findViewById(R.id.txtviewtimer);

        //inisalize time duration
        long duration = TimeUnit.MINUTES.toMillis(1);

        //initalize counterDown timer
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                //when tick
                //convert millisecondes to minute and second
                String sDuration = String.format(Locale.ENGLISH,"%02d : %02d",TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l),TimeUnit.MILLISECONDS.toSeconds(l)-
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMillis(l)));
                //set converted string in text view
                textView.setText(sDuration);

            }

            @Override
            public void onFinish() {
                //when finish hide text view
                textView.setVisibility(View.GONE);


            }
        }.start();


    }
}