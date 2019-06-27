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
			//String str2 = "<HTML><BODY><p>"+str+"</p></BODY></HTML>";
			
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

		return str;
		}

}
