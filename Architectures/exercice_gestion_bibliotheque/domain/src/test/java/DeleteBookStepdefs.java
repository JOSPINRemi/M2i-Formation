import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.Book;
import org.example.port.BookRepository;
import org.example.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DeleteBookStepdefs {
    private final BookService bookService;
    private final BookRepository bookRepository;
    private Book book;
    private List<Book> result;

    public DeleteBookStepdefs() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Given("there is book with the id {long} in the library")
    public void thereIsBookWithTheIdInTheLibrary(long id) {
        book = new Book("toto", "tata");
        Mockito.doAnswer(invocationOnMock -> {
            Book b = invocationOnMock.getArgument(0);
            b.setId(id);
            return null;
        }).when(bookRepository).create(book);
        bookService.createBook("toto", "tata");
    }

    @When("I delete the book with id {long}")
    public void iDeleteTheBookWithId(long id) {
        Mockito.when(bookRepository.findById(id)).thenReturn(book);
        bookService.deleteBook(id);

    }

    @Then("empty list should be returned")
    public void emptyListShouldBeReturned() {
        Mockito.when(bookRepository.search("toto")).thenReturn(List.of());
        result = bookService.searchBook("toto");
        Assertions.assertEquals(List.of(), result);
    }
}
