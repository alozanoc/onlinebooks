package pe.edu.pe.onlinebooks.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.pe.onlinebooks.controllers.dto.BookDTO;
import pe.edu.pe.onlinebooks.controllers.dto.CommentDTO;
import pe.edu.pe.onlinebooks.controllers.dto.CommentRequest;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.services.BookService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/books/{bookId}/feed")
public class BookFeedController {

    final BookService bookService;

    public BookFeedController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("comment")
    public ResponseEntity<BookDTO> comment(@PathVariable Integer bookId,
                                           @RequestBody CommentRequest request) {
        Book book = bookService.comment(null, bookId, request.getComment());
        BookDTO response = new BookDTO(book);
        return ResponseEntity.ok(response);
    }

}
