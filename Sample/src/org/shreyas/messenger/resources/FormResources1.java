package org.shreyas.messenger.resources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.json.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.shreyas.messenger.service.ClientClass;

@Path("/city")
public class FormResources1 {
		



	@POST
	
	public String City(
			@FormParam("City") String city){

		String str = ClientClass.main(city);
		System.out.println(str);
		
		int curr = str.indexOf("current");
		String location = (String)str.subSequence(1, curr-2);
		System.out.println(location);
		String current = str.substring(curr-1);
		System.out.println(current);
		int tempc = current.indexOf("temp_c");
		int tempf = current.indexOf("temp_f");
		
		int name = location.indexOf("name");
		int region = location.indexOf("region");
		
		int time_st = location.indexOf("localtime\"");
		int time_end = location.indexOf("\"}");
		
		System.out.println(location.substring(name+6, region-2));
		System.out.println(current.substring(tempc+8, tempf-2));
		System.out.println(location.substring(time_st, time_end));

		String str2 = "Current temperature in > "+location.substring(name+7, region-3)+"< is "+current.substring(tempc+8,tempf-2)+"\n"+"Time "+location.substring(time_st, time_end);
		JSONParser parser = new JSONParser();
		try {
			JSONObject jobj = (JSONObject)parser.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*			try {
				JSONParser parser = new JSONParser();
				JSONObject jobj = (JSONObject)parser.parse(str);
				
				String jarr = jobj.toJSONString();
				String TempFile = "Temp.txt";
				//System.out.println(jarr);
			    BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile ));
			    writer.write(jarr);
			     
			    writer.close();
				return jarr;
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}*/

		return "<HTML><BODY><h3>"+str2+"</h3></BODY></HTML>";
		}

}
