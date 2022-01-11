package com.lab9EEjava.JavaLab9EE;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/test")
@RequestScoped
public class TestController {

    @Path("/hello")
    @GET
    public String hello(){
        return "Hello service 2!";
    }

    @Path("/testServiceA")
    @GET
    public Response callServiceA(@QueryParam("token") String token) {
        WebTarget target = ClientBuilder.newClient().target("http://172.17.0.3:8080/JavaLab9EE/api/v1/documents/test");
        Response response = target.request().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).buildGet().invoke();
        System.out.println(response.readEntity(String.class));
        return Response.status(200).build();
    }

}
