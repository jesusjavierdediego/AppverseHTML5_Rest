package com.rest.restangular.server.rest.resource;

import com.rest.server.dao.TodoRepository;
import com.rest.server.model.Todo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/rest/todos")
public class TodoListResource {

    private TodoRepository repository = TodoRepository.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> list() {
        return repository.list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Todo todo) throws IOException {
        repository.create(todo);
    }

}
