package com.opendroid.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class PreferenceHelper {

	private SharedPreferences preferences;

	public PreferenceHelper(Context context) {
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public void add(String key, String value) {
		Editor editor = preferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public void clear() {
		// here you get your prefrences by either of two methods
		Editor editor = preferences.edit();
		editor.clear();
		editor.commit();
	}

	public String get(String key) {

		return preferences.getString(key, "");
	}

}
