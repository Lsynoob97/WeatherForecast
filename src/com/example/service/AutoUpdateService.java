package com.example.service;

import com.example.util.HttpCallbackListener;
import com.example.util.HttpUtil;
import com.example.util.Utility;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;

public class AutoUpdateService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	public int onStartCommand(Intent intent,int flags,int startId){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				updateWeather();
			}
			
		}).start();
		AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
		int anHour =8*60*60*1000;
		long triggerAtTime=SystemClock.elapsedRealtime()+anHour;
		Intent i=new Intent(this,AutoUpdateReceiver.class);
		PendingIntent pi=PendingIntent.getBroadcast(this, 0, i, 0);
		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime, pi);
		return super.onStartCommand(intent, flags, startId);
	}
	public void updateWeather(){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		String weatherCode=prefs.getString("weather_code","");
		String address="http://www.weather.com.cn/data/cityinfo/"+weatherCode+".html";
		HttpUtil.sendHttpRequest(address, new HttpCallbackListener()
		{

			@Override
			public void onFinish(String response) {
				// TODO Auto-generated method stub
				Log.d("TAG",response);
				Utility.handleWeatherResponse(AutoUpdateService.this, response);
			}

			@Override
			public void onError(Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
			
		});
	}

}
