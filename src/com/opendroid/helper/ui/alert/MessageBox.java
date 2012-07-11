package com.opendroid.helper.ui.alert;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/*
 * It creates the AlertDialog with Title and Okay button.It is used to display 
 * validation alerts, information about some functionality etc.
 */
public class MessageBox {

	public static final int CONFIRM_YES = 0;
	public static final int CONFIRM_NO = 1;

	private static int result;

	private static AlertDialog.Builder builder = null;

	public static void alert(Object msg, final Activity activity,
			final boolean exitOnOk) {

		builder = new AlertDialog.Builder(activity);

		if (msg instanceof String) {
			builder.setMessage("" + msg);
		} else {
			builder.setMessage(Integer.parseInt("" + msg));
		}

		builder.setTitle("Alert !")
				.setCancelable(false)
				.setNeutralButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								if (exitOnOk) {
									activity.finish();
								}
							}
						}).show();

	}

	public static int confirm(Object msg, final Activity activity) {

		result = CONFIRM_NO;

		builder = new AlertDialog.Builder(activity);

		if (msg instanceof String) {
			builder.setMessage("" + msg);
		} else {
			builder.setMessage(Integer.parseInt("" + msg));
		}

		builder.setTitle("Alert !")
				.setCancelable(false)
				.setPositiveButton(android.R.string.yes,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								result = CONFIRM_YES;
							}
						})
				.setNegativeButton(android.R.string.no,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// nothing to do
								result = CONFIRM_NO;
							}
						}).show();
		return result;

	}

	public static void alertAndRedirect(Object msg, final Activity source,
			final Class<?> destination) {

		builder = new AlertDialog.Builder(source);

		if (msg instanceof String) {
			builder.setMessage("" + msg);
		} else {
			builder.setMessage(Integer.parseInt("" + msg));
		}

		builder.setTitle("Alert !")
				.setCancelable(false)
				.setNeutralButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								source.startActivity(new Intent(source,
										destination));
							}
						}).show();

	}

	public static void alertAndRedirect(Object msg, final Activity source,
			final Class<?> destination, final Bundle parameter) {

		builder = new AlertDialog.Builder(source);

		if (msg instanceof String) {
			builder.setMessage("" + msg);
		} else {
			builder.setMessage(Integer.parseInt("" + msg));
		}

		builder.setTitle("Alert !")
				.setCancelable(false)
				.setNeutralButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

								Intent i = new Intent(source, destination);
								i.putExtras(parameter);
								source.startActivity(i);
							}
						}).show();

	}

}
