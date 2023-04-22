package pe.edu.pe.onlinebooks.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.repositories.BookRepository;
import pe.edu.pe.onlinebooks.services.BookService;

import java.time.LocalDateTime;

@Service
public class BookServiceImpl implements BookService {
    final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override public Book addBook(String title, String author, String description, MultipartFile image) {
        Book book = new Book(title, author, description, "", LocalDateTime.now(), LocalDateTime.now());
        return bookRepository.save(book);
    }
}
