package jsonWireProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class JsonWireP {

	@Test
	public void createNewSession() throws ClientProtocolException, IOException {
		
		HttpClient httpclient = HttpClientBuilder.create().build();
	
		//create session
		HttpPost httpPost = new HttpPost("http://localhost:4444/wd/hub/session");
		httpPost.setHeader("Content-Type", "application/json");			
		
		
		//build capabilities object
		JsonObject capabilities = new JsonObject();
		capabilities.addProperty("browserName", "firefox");
		
		JsonObject json = new JsonObject();
		json.add("desiredCapabilities", capabilities);
		
		//build POST and execute
		HttpEntity e = new StringEntity(json.toString());
		httpPost.setEntity(e);
	    HttpResponse response = httpclient.execute(httpPost);
	    
	    // Check for HTTP response code: 200 = success
	 	if (response.getStatusLine().getStatusCode() != 200) {
	 		throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
	 	}
	  
	 	// Get-Capture Complete application/xml body response
	 	BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
	 	String output;
	 	System.out.println("============Output:============");
	  
	 	// Simply iterate through XML response and show on console.
	 	while ((output = br.readLine()) != null) {
	 		System.out.println(output);
	 	} 		
	}
	
	
	@Test
	public void navigateToUrl() throws ClientProtocolException, IOException {
		
		HttpClient httpclient = HttpClientBuilder.create().build();
	
		//create session
		HttpPost httpPost = new HttpPost("http://localhost:4444/wd/hub/session/893200ae-98cc-4bbc-824b-331468e749a4/url");
		httpPost.setHeader("Content-Type", "application/json");			
		
		
		//build capabilities object
		JsonObject target = new JsonObject();
		target.addProperty("url", "http://gridfusion.net");
				
		//build POST and execute
		HttpEntity e = new StringEntity(target.toString());
		httpPost.setEntity(e);
	    HttpResponse response = httpclient.execute(httpPost);
	    
	    // Check for HTTP response code: 200 = success
	 	if (response.getStatusLine().getStatusCode() != 200) {
	 		throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
	 	}
	  
	 	// Get-Capture Complete application/xml body response
	 	BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
	 	String output;
	 	System.out.println("============Output:============");
	  
	 	// Simply iterate through XML response and show on console.
	 	while ((output = br.readLine()) != null) {
	 		System.out.println(output);
	 	} 		
	}
	
	@Test
	public void quit() throws ClientProtocolException, IOException {
		
		HttpClient httpclient = HttpClientBuilder.create().build();
	
		//create session
		HttpDelete httpDelete = new HttpDelete("http://localhost:4444/wd/hub/session/c9ce3053-9fb1-4518-813a-9bb9992df34a/window");		
		httpDelete.setHeader("Content-Type", "application/json");			
		
		

	    HttpResponse response = httpclient.execute(httpDelete);
	    
	    // Check for HTTP response code: 200 = success
	 	if (response.getStatusLine().getStatusCode() != 200) {
	 		throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
	 	}
	  
	 	// Get-Capture Complete application/xml body response
	 	BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
	 	String output;
	 	System.out.println("============Output:============");
	  
	 	// Simply iterate through XML response and show on console.
	 	while ((output = br.readLine()) != null) {
	 		System.out.println(output);
	 	} 		
	}
	
}