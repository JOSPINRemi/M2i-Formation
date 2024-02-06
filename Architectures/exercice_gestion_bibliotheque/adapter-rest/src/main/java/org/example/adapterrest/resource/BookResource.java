package org.example.adapterrest.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.adapterrest.dto.BookDTO;
import org.example.repository.BookEntityRepository;
import org.example.repository.impl.BookRepositoryImpl;
import org.example.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@Path("books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final BookService bookService;

    public BookResource() {
        bookService = new BookService(new BookRepositoryImpl(new BookEntityRepository()));
    }

    @GET
    @Path("{title}")
    public List<BookDTO> get(@PathParam("title") String title) {
        return bookService.searchBook(title)
                .stream().map(
                        book -> BookDTO.builder()
                                .id(book.getId())
                                .title(book.getTitle())
                                .author(book.getAuthor())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @POST
    public Response post(BookDTO bookDTO) {
        try {
            bookService.createBook(bookDTO.getTitle(), bookDTO.getAuthor());
            return Response.ok().build();
        }catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            bookService.deleteBook(id);
            return Response.ok().build();
        }catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }
}