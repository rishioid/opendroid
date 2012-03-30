package com.opendroid.helper;

import java.io.File;

public class StorageUtils {

/**
 * Returns internal storage directory with folder name specified or creates new
 * @param folder = name of folder that needs to be accessed
 * @return
 */
	public static String getInternalMemoryLocation(String folder)
	{
		String file = android.os.Environment.getDataDirectory().getAbsolutePath()+"/"+folder;
		File dir = new File(file);
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		return file;
	}
}
