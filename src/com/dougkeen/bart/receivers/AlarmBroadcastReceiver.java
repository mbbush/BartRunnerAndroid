package com.dougkeen.bart.receivers;

import com.dougkeen.bart.BartRunnerApplication;
import com.dougkeen.util.WakeLocker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		WakeLocker.acquire(context);

		BartRunnerApplication application = (BartRunnerApplication) context
				.getApplicationContext();
		application.setPlayAlarmRingtone(true);

		Intent targetIntent = new Intent(Intent.ACTION_VIEW, application
				.getBoardedDeparture().getStationPair().getUri());
		targetIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		context.startActivity(targetIntent);

		application.setAlarmPending(false);
	}

}