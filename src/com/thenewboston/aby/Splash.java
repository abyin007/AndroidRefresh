package com.thenewboston.aby;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {
	
	MediaPlayer welcomeSound = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		welcomeSound = MediaPlayer.create(Splash.this, R.raw.welcome_sound);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean sound = getPrefs.getBoolean("checkbox", true);
		if(sound ==  true){
			welcomeSound.start();
		}
		
		Thread timer = new Thread(){
			public void run() {
				try{
					sleep(2000);
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}finally{
					Intent openingStartingPoint = new Intent("com.thenewboston.aby.MENU");
					startActivity(openingStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		welcomeSound.release();
		finish();
	}

}
