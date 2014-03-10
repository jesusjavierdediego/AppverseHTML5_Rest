package com.rest.restangular.server.rest.resource;

import com.rest.server.dao.TodoRepository;
import com.rest.server.model.Todo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/rest/todos/{todoId}")
public class TodoResource {

    private TodoRepository repository = TodoRepository.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("todoId") Long todoId) {
        Todo todo = repository.get(todoId);
        if (todo == null) {
            return Response.noContent().build();
        }
        return Response.ok(todo).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Todo todo) throws IOException {
        repository.update(todo);
    }

    @DELETE
    public void remove(@PathParam("todoId") Long todoId) {
        repository.delete(todoId);
    }


}
