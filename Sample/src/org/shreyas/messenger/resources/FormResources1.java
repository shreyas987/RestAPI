package org.shreyas.messenger.resources;

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
	
	public JSONArray City(
			@FormParam("City") String city){

		String str = ClientClass.main(city);
		System.out.println(str);
			//String str2 = "<HTML><BODY><p>"+str+"</p></BODY></HTML>";
			
			try {
				JSONParser parser = new JSONParser();
				JSONObject jobj = (JSONObject)parser.parse(str);
				
				JSONArray jarr = (JSONArray)jobj.get(0);
				return jarr;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		
		}

}
