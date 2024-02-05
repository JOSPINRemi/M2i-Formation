package org.example.exercice_api_rest.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice_api_rest.dto.TodoDto;
import org.example.exercice_api_rest.service.TodoService;

import java.util.List;

@Path("todos")
public class TodoResource {

    private final TodoService todoService;

    @Inject
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GET
    public List<String> get() {
        return todoService.getTodos();
    }

    @GET
    @Path("{id}")
    public String get(@PathParam("id") Long id) {
        return todoService.getTodo(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TodoDto post(TodoDto todoDto) {
        return todoService.createTodo(todoDto);
    }

    @PATCH
    @Path("{id}")
    public String pathStatus(@PathParam("id") Long id) {
        return todoService.updateTodo(id);
    }

    @DELETE
    @Path("{id}")
    public String delete(@PathParam("id") Long id) {
        return todoService.delete(id);
    }
}
