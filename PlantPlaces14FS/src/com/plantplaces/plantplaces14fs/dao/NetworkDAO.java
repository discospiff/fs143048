package com.plantplaces.plantplaces14fs.dao;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Low level networking stuff, can 
 * be used with several DAOs.
 * @author jonesbr
 *
 */
public class NetworkDAO {

	public String fetch(String uri) throws Exception {
		
		// Http Client marries together a request and response.
		HttpClient httpClient = new DefaultHttpClient();
		
		// what URI do we want to receive?
		HttpGet httpGet = new HttpGet(uri);
	
		// handle the response
		ResponseHandler<String> responseHandler = new BasicResponseHandler();

		// access the URI and get back the return data.
		String returnData = null;

		returnData = httpClient.execute(httpGet, responseHandler);
		
		// return data
		return returnData;
	}
}
