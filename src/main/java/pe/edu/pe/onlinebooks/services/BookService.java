package pe.edu.pe.onlinebooks.services;

import org.springframework.web.multipart.MultipartFile;
import pe.edu.pe.onlinebooks.models.Book;

public interface BookService {
    Book addBook(String title, String author, String description, MultipartFile image);
}
