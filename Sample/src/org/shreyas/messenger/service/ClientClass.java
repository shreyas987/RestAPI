package org.shreyas.messenger.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClientClass {

	public static String main(String city) {
		String output = "";
		String output2 = "";
		JSONParser parse = new JSONParser();
		
		JSONObject obj = new JSONObject();
		try {
			String path = "http://api.apixu.com/v1/current.json?key=1f06579df1fb48c0b29152026191106&q="+ city;
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
           
            do {
            	output = br.readLine();
                output2+=output;
            }while ((output = br.readLine()) != null);
            System.out.println(br);
            conn.disconnect();
			String TempFile = "Temp.txt";
			BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile ));
		    writer.write(output2);
		     
		    writer.close();

       } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return "Please enter the correct City name";
        }
		
		return (String)output2;
	}
}