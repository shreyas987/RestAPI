package org.shreyas.messenger.resources;

import javax.ws.rs.Path;

import org.shreyas.messenger.database.DatabaseClass;
import org.shreyas.messenger.model.Message;
import org.shreyas.messenger.service.ClientClass;
import org.shreyas.messenger.service.MessageService;

import javax.ws.rs.POST;

import java.io.PrintWriter;
import java.util.Map;

import javax.json.JsonObject;
import javax.ws.rs.FormParam;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;


@Path("/add")
public class FormResource {
	MessageService messageService = new MessageService();
	

	@POST
	
	public String addUser(
			@FormParam("Message") String message1,
			@FormParam("Author") String author) {
			
		Message msg1 = new Message(100,message1,author);
			
			
			messageService.addMessage(msg1);
			return "Message : "+message1+" Author :"+author;

		}

}

