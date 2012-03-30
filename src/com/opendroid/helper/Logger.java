package com.opendroid.helper;

import org.apache.log4j.Level;

import android.os.Environment;
import android.util.Log;
import de.mindpipe.android.logging.log4j.LogConfigurator;

public class Logger {
	
	static
	{
		final LogConfigurator lconfig = new LogConfigurator();
		lconfig.setFileName(Environment.getExternalStorageDirectory()+"/"+Logger.class+".txt");
		lconfig.setLevel("ALL", Level.ALL);
		lconfig.configure();
	}
	
	public static void info(Class<?> clas, String message)
	{
		org.apache.log4j.Logger.getLogger(clas).info(message);
		Log.i(clas.getName(), message);
	}
	
	public static void error(Class<?> clas, String message)
	{
		org.apache.log4j.Logger.getLogger(clas).error(message);
		Log.e(clas.getName(), message);
	}
	
	public static void error(Class<?> clas, Exception message)
	{
		org.apache.log4j.Logger.getLogger(clas).error(message);
		Log.e(clas.getName(), message.getMessage());
	}
	
	public static void debug(Class<?> clas, String message)
	{
		org.apache.log4j.Logger.getLogger(clas).debug(message);
		Log.d(clas.getName(), message);
	}

}
