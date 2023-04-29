package pe.edu.pe.onlinebooks.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.pe.onlinebooks.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b WHERE " +
            "UPPER(b.title) LIKE UPPER(CONCAT('%', :title, '%')) AND " +
            "UPPER(b.author) LIKE UPPER(CONCAT('%', :author, '%')) AND " +
            "(:genre IS NULL OR :genre = '' OR UPPER(b.genre) = UPPER(:genre))"
    )
    Page<Book> advanceSearch(String title, String author, String genre, PageRequest page);
}