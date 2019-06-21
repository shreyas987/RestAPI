package org.shreyas.messenger.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.shreyas.messenger.service.ClientClass;

@Path("/city")
public class FormResources1 {
		

	@POST
	
	public String City(
			@FormParam("City") String city){

			String str = ClientClass.main(city);
			System.out.println(str);
			String str2 = "<HTML><BODY><p>"+str+"</p></BODY></HTML>";
			return str2;
		}

}
