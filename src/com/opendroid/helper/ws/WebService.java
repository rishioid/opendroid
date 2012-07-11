package com.opendroid.helper.ws;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

import com.google.gson.Gson;
import com.opendroid.helper.ws.models.WSModel;

public abstract class WebService<T extends WSModel> {

	protected final String ALL_PATIOS = "http://profiles.blogto.com/api/patios?format=json";

	/*
	 * returns the url of the webservice
	 */
	protected abstract String getURL();

	/*
	 * returns the mapper class
	 */
	protected abstract Class getMapperClass();

	public T getResponse() {
		InputStream source = fetchStream(getURL());
		Gson gson = new Gson();
		Reader reader = new InputStreamReader(source);
		T response = (T) gson.fromJson(reader, getMapperClass());
		return response;
		// List<Result> results = response.results;
	} // end callWebService()

	private InputStream fetchStream(String url) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse getResponse = client.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				Log.d(getClass().getSimpleName(), "Error " + statusCode
						+ " for URL " + url);
				return null;
			}
			HttpEntity getResponseEntity = getResponse.getEntity();
			return getResponseEntity.getContent();
		} catch (IOException e) {
			getRequest.abort();
			Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
		}

		return null;

	}

}
