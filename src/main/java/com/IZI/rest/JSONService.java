package com.IZI.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONService {

	@GET
	@Path("/get")
	@Produces("application/json")
	public Product getProductInJSON() {

		Product product = new Product();
		String [] values = FeedData.readDatabaseForReorder();
		product.setName(values[0]);
		product.setQty(Integer.valueOf(values[1]));
		return product; 

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {

		String result = "Product sent : " + product;
		return Response.status(201).entity(result).build();
		
	}
	
}