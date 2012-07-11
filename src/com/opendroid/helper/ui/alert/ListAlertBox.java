package com.opendroid.helper.ui.alert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

//import com.centron.R;

public class ListAlertBox implements AlertBox, OnItemClickListener {

	Context cxt;
	String title;
	View view;
	
	AlertDialog.Builder builder;
	AlertDialog alertDialog;
	
	Object selectedValue;
	
	public ListAlertBox(Context cxt, String title, int layout_id, ViewGroup root, ArrayList<Map<String, String>> arrayList, OnItemClickListener onItemClickListener)
	{
		this.cxt = cxt;
		this.title = title;
		
		LayoutInflater inflator = (LayoutInflater)cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflator.inflate(layout_id, root);
		builder = new AlertDialog.Builder(cxt);
		builder.setView(layout);
	
		ListView weblv = /*(ListView) layout.findViewById(R.id.WebServiceList);    */ null;
        
		
		String[] from = { "name", "value" };
		int[] to = { android.R.id.text1, android.R.id.text2 };

		SimpleAdapter adapter = new SimpleAdapter(cxt, arrayList,
				android.R.layout.simple_list_item_2, from, to);
		weblv.setAdapter(adapter);
		weblv.setOnItemClickListener(onItemClickListener);
		
		alertDialog = builder.create();
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		alertDialog.show();
	}

	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		alertDialog.dismiss();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}
	
	public Object getSelectedValue()
	{
		return selectedValue;
	}
	
	public void bind(View view)
	{
		this.view = view;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
		// TODO Auto-generated method stub
		selectedValue =  ((HashMap<String, String>)arg0.getItemAtPosition(index)).get("value");
//		if()
	}

}
