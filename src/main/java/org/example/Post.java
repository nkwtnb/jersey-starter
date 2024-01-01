package org.example;

import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.HashMap;

// post request to http://localhost:8080/post
@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
public class Post {
    @Context
    Request request;

    @Context
    UriInfo uriInfo;
    @Context
    HttpHeaders httpHeaders;
    @FormDataParam("key1") String key1;
    @POST
    public Response handler() {
        System.out.println(key1);
        HashMap<String, String> result = new HashMap<>();
        result.put("Hello", "World");
        return Response
                .ok()
                .entity(result)
                .build();
    }
}
