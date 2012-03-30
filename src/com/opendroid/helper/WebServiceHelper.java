package com.opendroid.helper;

import java.util.HashMap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class WebServiceHelper {

	private String namespace;
	private String url;
	static SoapObject resultstring;

	public WebServiceHelper(String url, String namespace) {
		this.url = url;
		this.namespace = namespace;
	}

	private static void fillRequestWithParameters(SoapObject request,
			HashMap<String, Object> params) {
		for (String key : params.keySet()) {
			request.addProperty(key, params.get(key));
			Log.d(key + ":", "" + params.get(key));
		}
	}

	/** Called when the activity is first created. */
	public SoapObject getResponse(String method,
			HashMap<String, Object> params) {
		Log.d("namespace", "" + namespace);
		Log.d("method", "" + method);
		SoapObject request = new SoapObject(namespace, method);

		// Use this to add parameters
		if(!params.isEmpty()){
//			if((method).equalsIgnoreCase("GetHelpdesksFromCustomer")){
//				
//				SoapObject filter = new SoapObject(namespace, "Filter");
//				
////				PropertyInfo userId = new PropertyInfo();
////			    userId.setName("UserID");
////			    userId.setValue("00028555");
////			    userId.setType(RequestHeaderUser.class);
//
//				
//				filter.addProperty("ParameterName", "Name");
//				filter.addProperty("Value", "Apple Inc.");
//				filter.addProperty("Type", "System.String");
//				filter.addProperty("Comparer", "like");
//				filter.addProperty("IsParamList", "false");
//				
//				request.addProperty("ticket", "0C882A384CC161791C8C862F5590B82D65A1D4B2");
//				request.addProperty("filter", filter);
//
//				
//			}else{
				fillRequestWithParameters(request, params);
//			}
		}
		

		// Declare the version of the SOAP request
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);

		// Needed to make the internet call
		Log.d("url", "" + url);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(url);
		androidHttpTransport.debug = true;
		
		try {
			// this is the actual part that will call the webservice
			Log.d("SOAP namespace method", namespace + "/" + method);
			androidHttpTransport.call(namespace + "/" + method, envelope);
			Log.d("requestDump", "" + androidHttpTransport.requestDump);
			Log.d("responseDump", "" + androidHttpTransport.responseDump);
			
//			Object result = envelope.getResponse();
			SoapObject result = (SoapObject)envelope.bodyIn;
			Log.d("result", "" + result.toString());
			resultstring =  result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultstring;

	}
	
	public boolean isNullOrEmpty(String str)
	{
		if(str==null || str.trim().equals("null") || str.trim().length() == 0)
		{
			return true;
		}
		return false;
	}
}
