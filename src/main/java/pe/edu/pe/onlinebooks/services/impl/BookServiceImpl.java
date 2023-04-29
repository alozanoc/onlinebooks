package pe.edu.pe.onlinebooks.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.models.Comment;
import pe.edu.pe.onlinebooks.models.User;
import pe.edu.pe.onlinebooks.repositories.BookRepository;
import pe.edu.pe.onlinebooks.repositories.CommentRepository;
import pe.edu.pe.onlinebooks.services.BookService;

import java.time.LocalDateTime;

@Service
public class BookServiceImpl implements BookService {
    final BookRepository bookRepository;
    final CommentRepository commentRepository;

    public BookServiceImpl(BookRepository bookRepository, CommentRepository commentRepository) {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }

    @Override public Book addBook(String title, String author, String description, MultipartFile image) {
        Book book = new Book(title, author, description, "", LocalDateTime.now(), LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public Page<Book> advanceSearch(String title, String author, String genre, PageRequest page) {
        return bookRepository.advanceSearch(title, author, genre, page);
    }

    @Override
    public Book comment(User o, Integer bookId, String comment) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        commentRepository.save(new Comment(comment, book, o));
        return book;
    }
}
