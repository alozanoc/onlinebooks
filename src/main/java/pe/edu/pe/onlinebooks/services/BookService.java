package pe.edu.pe.onlinebooks.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.models.User;

public interface BookService {
    Book addBook(String title, String author, String description, MultipartFile image);

    Page<Book> advanceSearch(String title, String author, String genre, PageRequest page);

    Book comment(User o, Integer bookId, String comment);
}
