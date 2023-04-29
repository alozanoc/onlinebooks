package pe.edu.pe.onlinebooks.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {


}