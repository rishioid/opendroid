package com.opendroid.helper.ui.alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;

//import com.centron.R;

public class MultiListAlertBox implements AlertBox, OnItemClickListener {

	Context cxt;
	String title;
	View view;
	
	AlertDialog.Builder builder;
	AlertDialog alertDialog;
	
	Object selectedValue;
	
	Button btn;
	
	public MultiListAlertBox(Context cxt, String title, String[] items, boolean[] selectedIndexes, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener, android.content.DialogInterface.OnClickListener onCLickListener)
	{
		this.cxt = cxt;
		this.title = title;
		
/*		LayoutInflater inflator = (LayoutInflater)cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflator.inflate(layout_id, root);
		builder = new AlertDialog.Builder(cxt);
		builder.setView(layout);
	
		ListView weblv = (ListView) layout.findViewById(R.id.parts_list);
        btn = (Button) layout.findViewById(R.id.btnSelectPopup);
		
		String[] from = { "name", "value" };
		int[] to = { android.R.id.text1, android.R.id.text2 };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(cxt,
				android.R.layout.simple_list_item_multiple_choice, arrayList);
		weblv.setAdapter(adapter);
		
		weblv.setOnItemClickListener(onItemClickListener);
		btn.setOnClickListener(onCLickListener);*/
		
		alertDialog = new AlertDialog.Builder( cxt )
	       .setTitle( title )
	       .setMultiChoiceItems( items, selectedIndexes, onMultiChoiceClickListener )
	       .setPositiveButton( "OK", onCLickListener )
	       .create();
		
//		alertDialog = builder.create();
		
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
		selectedValue =  ((String)arg0.getItemAtPosition(index));
//		if()
	}

}
