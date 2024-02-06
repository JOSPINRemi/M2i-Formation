package org.example.exercice_api_rest.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice_api_rest.dto.TodoDto;
import org.example.exercice_api_rest.service.TodoService;

import java.util.List;

@Path("todos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {
    private final TodoService todoService;

    @Inject
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GET
    public List<TodoDto> get() {
        return todoService.getTodos();
    }

    @GET
    @Path("{id}")
    public TodoDto get(@PathParam("id") Long id) {
        return todoService.getTodo(id);
    }

    @POST
    public TodoDto post(TodoDto todoDto) {
        return todoService.createTodo(todoDto);
    }

    @PATCH
    @Path("{id}")
    public TodoDto pathStatus(@PathParam("id") Long id) {
        return todoService.changeStatus(id);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") Long id) {
        return todoService.delete(id);
    }
}
