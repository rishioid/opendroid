package com.opendroid.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileHelper {

	public static long getFileSize(String filename) {
		File file = new File(filename);
		return file.length();
	}

	public static boolean writeFile(String filename, byte[] bytes) {
		boolean done = false;
		try {
			FileOutputStream fOut = new FileOutputStream(filename);
			OutputStreamWriter osw = new OutputStreamWriter(fOut);
			for (int i = 0; i < bytes.length; i += 2) {
				fOut.write(bytes[i]);
			}
			osw.flush();
			osw.close();
			done = true;
		} catch (Exception e) {
			Logger.error(FileHelper.class, e.getMessage());
			done = false;
		}
		return done;
	}

}
