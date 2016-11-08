package com.countdown.tinonino;

import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class Countdown extends Activity {
	
	Button btnStart, btnStop;
	TextView textViewTime;
	MediaPlayer mpCountdown;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_countdown);

		final MediaPlayer mpCountdown = MediaPlayer.create(this,R.raw.heathens);
		
		btnStart = (Button) findViewById(R.id.btnStart);	
		btnStop = (Button) findViewById(R.id.btnStop);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
			
			textViewTime.setText("00:03:00");
			
		final CounterClass timer = new CounterClass(180000, 1000);
		btnStart.setOnClickListener(new OnClickListener() {
			
			
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timer.start();
				mpCountdown.start();
			}
		});
		
		btnStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timer.cancel();
				mpCountdown.release();
			}
		});
		
		
	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	public class CounterClass extends CountDownTimer {

		public CounterClass(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
		}

		@SuppressLint("NewApi")
		@TargetApi(Build.VERSION_CODES.GINGERBREAD)
		@Override
		public void onTick(long millisUntilFinished) {
			// TODO Auto-generated method stub
			
			long millis = millisUntilFinished;
			String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
					TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
					TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
			System.out.println(hms);
			textViewTime.setText(hms);
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			textViewTime.setText("Completed.");
			
		
		}
		
		
	}
	
	
}
		