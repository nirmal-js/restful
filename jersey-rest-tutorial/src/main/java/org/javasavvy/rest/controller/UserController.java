package org.javasavvy.rest.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.javasavvy.rest.modal.UserModal;

@Path("/user")
public class UserController {

	@GET
	@Path("/user-info/{userId}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserModal getUserInfo(@PathParam("userId") long userId) {

		UserModal userModal = new UserModal();
		userModal.setEmail("javasavvy@gmail.com");
		userModal.setAge(10);
		userModal.setFirstName("jayaram");
		userModal.setLastName("vijay");
		return userModal;
	}

	@GET
	@Path("/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<UserModal> getUsersList() {
		ArrayList<UserModal> list = new ArrayList<UserModal>();
		UserModal userModal = new UserModal();
		userModal.setEmail("rest-hellow@gmail.com");
		userModal.setAge(10);
		userModal.setFirstName("rest example");
		userModal.setLastName("jersey");
		list.add(userModal);

		UserModal userModal1 = new UserModal();
		userModal1.setEmail("jayaram3@gmail.com");
		userModal1.setAge(21);
		userModal1.setFirstName("test2");
		userModal1.setLastName("vijay");
		list.add(userModal1);
		return list;
	}

	@GET
	@Path("/query-param")
	@Produces("text/html")
	public Response getResultByPassingQueryValue(@QueryParam("nameKey") String name,
			@QueryParam("countryKey") String country) {

		String output = "Customer name - " + name + ", Country - " + country + "";
		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/matrix-param")
    @Produces("text/html")
    public Response getResultByPassingMatrixValue(
                    @MatrixParam("nameKey") String name,
                    @MatrixParam("countryKey") String country) {
        
        String output = "Customer name - "+name+", Country - "+country+"";
        return Response.status(200).entity(output).build();
 
    }

}
