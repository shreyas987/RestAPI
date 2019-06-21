package org.shreyas.messenger.service;

import javax.ws.rs.GET;
import javax.net.ssl.*;
import javax.security.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;




@Path("")
public class Webapi {

	@GET
	public String Webapi1() {
		return "Welcome to WebAPI";
	}
	
}
