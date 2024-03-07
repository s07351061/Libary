import java.awt.print.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookByIsbn(String isbn);
    boolean addBook(Book book);
    boolean deleteBook(String isbn);
    boolean updateBook(Book book);
}
