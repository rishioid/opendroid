package com.opendroid.helper;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Settings {

	private static final String APPLICATION_MODE = "application_mode";
	private static final String SERVER = "server";
	private static final String SERVER_LIST = "server_list";
	private static final String DEVICE_ID = "device_id";
	private static final String TICKET = "ticket";

	public static final String MODE_ONLINE = "online";
	public static final String MODE_OFFLINE = "offline";

	private SharedPreferences preferences;

	public Settings(Context context) {
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public String getApplicationMode() {
		return preferences.getString(APPLICATION_MODE, null);
	}

	public String getServer() {
		return preferences.getString(SERVER, null);
	}

	public String getDeviceID() {
		return preferences.getString(DEVICE_ID, null);
	}

	public String getTicket() {
		return preferences.getString(TICKET, null);
	}

	public void setApplicationMode(String appMode) {
		Editor editor = preferences.edit();
		editor.putString(APPLICATION_MODE, appMode);
		editor.commit();
	}

	public void setServer(String server) {
		Editor editor = preferences.edit();
		editor.putString(SERVER, server);
		editor.commit();
	}

	public void setDeviceID(String deviceid) {
		Editor editor = preferences.edit();
		editor.putString(DEVICE_ID, deviceid);
		editor.commit();
	}

	public void setTicket(String ticket) {
		Editor editor = preferences.edit();
		editor.putString(TICKET, ticket);
		editor.commit();
	}

	public String[] getServerList() {
		String value = preferences.getString(SERVER_LIST, null);
		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();
		return gson.fromJson(value, String[].class);
	}


	public void addServer(String name, String url) {

		try {
			String value = preferences.getString(SERVER_LIST, null);

			ArrayList<String> aList = new ArrayList<String>();
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			if (value == null || 1==1) {
				value = "['" + name + "," + url + "']";
				String ints2[] = gson.fromJson(value, String[].class);
				String z = gson.toJson(ints2);
				aList.add(z);
				Log.d("valuer", "value=" + z);
				Log.d("length", "length=" + z.length());
				Log.d("list", "list=" + aList);
				Editor e = preferences.edit();
				e.putString(SERVER_LIST, z);
				e.commit();
			} else {
				String ints2[] = gson.fromJson(value, String[].class);
				String z = gson.toJson(ints2);
				for (int i = 0; i < ints2.length; i++) {
					aList.add(ints2[i]);
				}
				Log.d("valuer", "value=" + z);
				Log.d("length", "length=" + z.length());
				Log.d("ele", "" + ints2[0]);
				Editor e = preferences.edit();
				e.putString(SERVER_LIST, z);
				e.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void set(HashMap<String, String> map) {
		Editor editor = preferences.edit();
		if (map.containsKey(APPLICATION_MODE))
			editor.putString(APPLICATION_MODE, map.get(APPLICATION_MODE));
		if (map.containsKey(SERVER))
			editor.putString(SERVER, map.get(SERVER));
		if (map.containsKey(DEVICE_ID))
			editor.putString(DEVICE_ID, map.get(DEVICE_ID));
		if (map.containsKey(TICKET))
			editor.putString(TICKET, map.get(TICKET));
		editor.commit();
	}

}
