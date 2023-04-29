package pe.edu.pe.onlinebooks.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestParam String title,
                                        @RequestParam String author,
                                        @RequestParam String description,
                                        @RequestParam MultipartFile image) {
        Book newBook = bookService.addBook(title, author, description, image);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping
    @RequestMapping("/search")
    public ResponseEntity<List<Book>> advanceSearch(@RequestParam String title) {
        throw new RuntimeException("No implementado");
    }
}
