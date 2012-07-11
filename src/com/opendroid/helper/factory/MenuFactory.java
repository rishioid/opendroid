package com.opendroid.helper.factory;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.opendroid.helper.Logger;

public class MenuFactory {

	private static final Map<Integer, Class<?>> ActivityMap = new HashMap<Integer, Class<?>>();
	private static final Map<String, Integer> ClassMap = new HashMap<String, Integer>();

	static {
//		ClassMap.put("com.patio.ui.StartupActivity", R.menu.main);
/*		ClassMap.put("com.fitness.ui.HomeActivity", R.menu.main);
		ClassMap.put("com.fitness.ui.ChartActivity", R.menu.main);
		ClassMap.put("com.fitness.ui.WalkerActivity", R.menu.main);
		ClassMap.put("name.bagi.levente.pedometer.Settings", R.menu.main);*/
		
		/*ActivityMap.put(R.id.mniStatsInput, StatsInputActivity.class);
		ActivityMap.put(R.id.mniWalker, WalkerActivity.class);
		ActivityMap.put(R.id.mniChart, ChartActivity.class);
		ActivityMap.put(R.id.mniSettings, Settings.class);*/
		

	}

	public static void createMenuForClass(Activity activity, Menu menu) {
		Integer act = ClassMap.get(activity.getClass().getName());
		Log.d("Class", activity.getClass().getName() + "");
		if (act != null) {
			activity.getMenuInflater().inflate(
					ClassMap.get(activity.getClass().getName()), menu);
		}
	}

	public static void regiserMenuListenerForClass(Activity activity,
			MenuItem item) {

		Class clas = ActivityMap.get(item.getItemId());

		if (clas != null) {
			
				activity.startActivity(new Intent(activity, ActivityMap
						.get(item.getItemId())));
		} else {
			Logger.debug(
					MenuFactory.class,
					"no menu action registered for this event : "
							+ item.getItemId());
		}
	}
}
