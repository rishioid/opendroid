package com.opendroid.helper.ui;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.EditText;

public class UIHelper {
	
	public static void fillAllEditTextIfEmpty(ViewGroup v, Object defaultValue)
	{
//		ViewGroup v = (ViewGroup)cxt.getWindow().getDecorView();
		
	    for (int i = 0; i < v.getChildCount(); i++)
	    {
	        Object child = v.getChildAt(i); 
	        if (child instanceof EditText)
	        {
	            EditText e = (EditText)child;
	            if(e.getText().length() == 0)    // Whatever logic here to determine if valid.
	            {
	                e.setText(defaultValue+"");   // Stops at first invalid one. But you could add this to a list.
	            }
	        }
	        else if(child instanceof ViewGroup)
	        {
	            fillAllEditTextIfEmpty((ViewGroup)child, defaultValue);  // Recursive call.
	        }
	    }
	}
	
	public static void fillAllEditTextIfEmpty(EditText[] txts, Object defaultValue)
	{
		
	    for (EditText txt : txts)
	    {
	            if(txt.getText().length() == 0)    // Whatever logic here to determine if valid.
	            {
	            	txt.setText(defaultValue+"");   // Stops at first invalid one. But you could add this to a list.
	            }
	     
	    }
	}

}
