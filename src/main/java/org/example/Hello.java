package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

// get request to http://localhost:8080/hello
@Path("/hello")
public class Hello {
    @GET
    public Response handler() {
        return Response
                .ok()
                .entity("Hello world")
                .build();
    }
}
