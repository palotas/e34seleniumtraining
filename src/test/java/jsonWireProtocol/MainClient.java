package jsonWireProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class MainClient {
		
	/*
	 * first step is to create a session with the server
	 * the server will respond with a session ID which needs to be used in 
	 * subsequent calls 
	 */
	
	@Test
	public void createSession() throws ClientProtocolException, IOException, JSONException {
		
		DefaultHttpClient httpclient = new DefaultHttpClient();
	
		//create session
		HttpPost httpPost = new HttpPost("http://localhost:4444/wd/hub/session");
		httpPost.setHeader("Content-Type", "application/json");			
		
		
		
		//build capabilities object
		JSONObject capabilities = new JSONObject();
		capabilities.put("browserName", "firefox");
		
		JSONObject json = new JSONObject();
		json.put("desiredCapabilities", capabilities);
		
		//build POST and execute
		HttpEntity e = new StringEntity(json.toString());
		httpPost.setEntity(e);
	    HttpResponse response = httpclient.execute(httpPost);
	    
	    //print server response
	    System.out.println(response.getStatusLine());
	    System.out.println(response.getFirstHeader("Location"));
	}

	

	/*
	 * navigate to a specified URL 
	 */
	@Test
	public void navigateToUrl() throws ClientProtocolException, IOException, JSONException {
		
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://localhost:4444/wd/hub/session/ce929fb1-ab08-4063-b602-bdaf66ff1f78/url");
		httpPost.setHeader("Content-Type", "application/json");			
		JSONObject json = new JSONObject();
		json.put("url", "http://www.abraxas.ch");
		HttpEntity e = new StringEntity(json.toString());
		httpPost.setEntity(e);
	    HttpResponse response = httpclient.execute(httpPost);
	    
	    System.out.println(response.getStatusLine());	
	}
	
	
	/*
	 * get the current URL of where the browser is at the moment
	 */
	@Test
	public void getCurrentURL() throws ClientProtocolException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = httpclient.execute(new HttpGet("http://localhost:4444/wd/hub/session/ce929fb1-ab08-4063-b602-bdaf66ff1f78/url"));

		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");

		System.out.println(response.getStatusLine());	
		System.out.println(responseString);
		
	
	}
		
	
	/*
	 * find an element that the user wants to interact with 
	 */
	@Test
	public void findElementSearchField() throws ClientProtocolException, IOException, JSONException {

		DefaultHttpClient httpclient = new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost("http://localhost:4444/wd/hub/session/ce929fb1-ab08-4063-b602-bdaf66ff1f78/element");
		httpPost.setHeader("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("using", "id");
		json.put("value", "searchField");
		
		HttpEntity e = new StringEntity(json.toString());
		httpPost.setEntity(e);
	    HttpResponse response = httpclient.execute(httpPost);

	    System.out.println(response.getStatusLine());
	    
		BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
				
		}		
	}
	

	/*
	 * type some text into the input field that was located by the 
	 * findElementQ() method
	 */
	@Test
	public void typeJava() throws ClientProtocolException, IOException, JSONException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost("http://localhost:4444/wd/hub/session/ce929fb1-ab08-4063-b602-bdaf66ff1f78/element/0/value");
		httpPost.setHeader("Content-Type", "application/json");

		JSONArray array = new JSONArray();
		array.put("J");
		array.put("A");
		array.put("V");
		array.put("A");

		
		JSONObject json = new JSONObject();
		json.put("value", array);
		
		HttpEntity e = new StringEntity(json.toString());
		httpPost.setEntity(e);
	    HttpResponse response = httpclient.execute(httpPost);

	    System.out.println(response.getStatusLine());
	    		
	}
	

}
