package com.opendroid.helper.ui.alert;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class SingleListAlertBox implements AlertBox {
	
	AlertDialog alert;
	String title;
	
	public SingleListAlertBox(Context cxt, String title, String[] list, DialogInterface.OnClickListener listener)
	{
		this.title = title;
//		final String[] items = {"Red", "Green", "Blue"};

		AlertDialog.Builder builder = new AlertDialog.Builder(cxt);
		builder.setTitle(title);
		builder.setItems(list, listener);
		alert = builder.create();
	}

	@Override
	public void show() {
		alert.show();
	}

	@Override
	public void dismiss() {
	alert.dismiss();
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

}
