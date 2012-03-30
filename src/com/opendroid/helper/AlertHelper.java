package com.opendroid.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/*
 * It creates the AlertDialog with Title and Okay button.It is used to display 
 * validation alerts, information about some functionality etc.
 */
public class AlertHelper {

	private static AlertDialog.Builder builder = null;

	public static void Alert(String msg, Context context) {

		builder = new AlertDialog.Builder(context);
		builder.setMessage(msg)
				.setTitle("Alert !")
				.setCancelable(true)
				.setNeutralButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).show();

	}
	
	public static void Alert(int id, Context context) {

		builder = new AlertDialog.Builder(context);
		builder.setMessage(id)
				.setTitle("Alert !")
				.setCancelable(true)
				.setNeutralButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).show();

	}
}
