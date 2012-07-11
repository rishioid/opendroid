package com.opendroid.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.kobjects.base64.Base64;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

public class BitmapUtils {

	public static Bitmap decodeFile(String fileName) {
		try {
			File f = new File(fileName);
			// Decode image size
			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(new FileInputStream(f), null, o);

			// The new size we want to scale to
			final int REQUIRED_SIZE = 60;

			// Find the correct scale value. It should be the power of 2.
			int width_tmp = o.outWidth, height_tmp = o.outHeight;
			int scale = 1;
			while (true) {
				if (width_tmp / 2 < REQUIRED_SIZE
						|| height_tmp / 2 < REQUIRED_SIZE)
					break;
				width_tmp /= 2;
				height_tmp /= 2;
				scale++;
			}

			// Decode with inSampleSize
			BitmapFactory.Options o2 = new BitmapFactory.Options();
			o2.inSampleSize = scale;
			return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
		} catch (FileNotFoundException e) {
		}
		return null;
	}

	public static String encodeFile(Bitmap bm) {

		try {

			// Decode image size
			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			bm.compress(CompressFormat.PNG, 0 /* ignored for PNG */, bos);
			byte[] bitmapdata = bos.toByteArray();

			return Base64.encode(bitmapdata);

			// return Image64;
		} catch (Exception e) {
			Logger.error(BitmapUtils.class, e.toString());
		}
		return null;
	}

	// ------------------------------- save and retrieve bitmap

	public static File getSavePath() {
		File path;
		if (hasSDCard()) { // SD card
			path = new File(getSDCardPath() + "/KYC/");
			path.mkdir();
		} else {
			path = Environment.getDataDirectory();
		}
		return path;
	}

	public static String getCacheFilename() {
		File f = getSavePath();
		return f.getAbsolutePath() + "/cache.png";
	}

	public static Bitmap loadFromFile(String filename) {
		try {
			File f = new File(filename);
			if (!f.exists()) {
				return null;
			}
			Bitmap tmp = BitmapFactory.decodeFile(filename);
			return tmp;
		} catch (Exception e) {
			return null;
		}
	}

	public static Bitmap loadFromCacheFile() {
		return loadFromFile(getCacheFilename());
	}

	public static void saveToCacheFile(Bitmap bmp) {
		saveToFile(getCacheFilename(), bmp);
	}

	public static void saveToFile(String filename, Bitmap bmp) {
		try {
			FileOutputStream out = new FileOutputStream(filename);
			bmp.compress(CompressFormat.PNG, 100, out);
			out.flush();
			out.close();
		} catch (Exception e) {
		}
	}

	public static boolean hasSDCard() { // SD????????
		String status = Environment.getExternalStorageState();
		return status.equals(Environment.MEDIA_MOUNTED);
	}

	public static String getSDCardPath() {
		File path = Environment.getExternalStorageDirectory();
		return path.getAbsolutePath();
	}

	// ------------------- save on validate

	public static void saveBitmap(String fileNmae, Bitmap bm) {
		try {
			String mBaseFolderPath = Environment.getExternalStorageDirectory()
					.toString();
			String mFilePath = mBaseFolderPath + fileNmae + ".jpg";

			FileOutputStream stream = new FileOutputStream(mFilePath);
			bm.compress(CompressFormat.JPEG, 100, stream);
			stream.flush();
			stream.close();
		} catch (Exception e) {
			Log.e("Could not save", e.toString());
		}
	}

	/**
	 * write to external storage
	 */
	public static boolean createExternslDirIfNotExists(String path, Bitmap bm,
			String fileName) {
		boolean ret = true;

		Logger.error(BitmapUtils.class,
				"PATH " + Environment.getExternalStorageDirectory() + path);

		File file = new File(Environment.getExternalStorageDirectory() + "/"
				+ path);
		Logger.info(BitmapUtils.class, "file initialized");
		if (!file.exists()) {
			Logger.info(BitmapUtils.class, "Creating new file");
			if (!file.mkdir()) {

				Logger.error(BitmapUtils.class, "Problem creating Image folder");
				ret = false;
			}
		} else {
			Logger.info(BitmapUtils.class, "Writing file");
			file = new File(Environment.getExternalStorageDirectory() + "/"
					+ path, fileName);

			OutputStream outStream = null;

			try {
				outStream = new FileOutputStream(file);
				Logger.info(BitmapUtils.class,
						"filepath " + file.getAbsolutePath());
				if (bm == null) {
					
					// code here to set empty image

//					bm = BitmapFactory.decodeResource(
//							RegisterScreen.context.getResources(),
//							R.drawable.noimage);

				} else {
					bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
				}

				outStream.flush();
				outStream.close();

			} catch (FileNotFoundException e) {
				Logger.error(BitmapUtils.class, "" + e);
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IOException e) {
				Logger.error(BitmapUtils.class, "" + e);
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

		return ret;
	}

}
