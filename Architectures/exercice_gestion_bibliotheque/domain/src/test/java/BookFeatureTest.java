import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.Book;
import org.example.port.BookRepository;
import org.example.service.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookFeatureTest {

    /*@AfterEach
    void close() throws Exception {
        autoCloseable.close();
    }*/
//    @Mock
    private final BookRepository bookRepository;
    private BookService bookService;
    private Book book;

//    private AutoCloseable autoCloseable;

    /*@BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }*/
    private List<Book> resultSearch;

    public BookFeatureTest() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
        book = new Book("toto", "tata");
    }

    @Given("there are some books in the library")
    public void there_are_some_books_in_the_library() {
        Mockito.doAnswer(invocationOnMock -> {
            Book b = invocationOnMock.getArgument(0);
            b.setId(1L);
            return null;
        }).when(bookRepository).create(book);

        bookService.createBook("toto", "tata");
    }

    @When("I search for books with title started with {string}")
    public void i_ask_for_all_books(String search) {
        Mockito.when(bookRepository.search(search)).thenReturn(List.of(book));
        resultSearch = bookService.searchBook(search);
    }

    @Then("List with {int} book should be returned")
    public void all_books_should_be_returned(int size) {
        Assertions.assertEquals(size, resultSearch.size());
    }
}
