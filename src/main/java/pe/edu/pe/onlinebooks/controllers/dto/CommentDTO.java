package pe.edu.pe.onlinebooks.controllers.dto;

import jakarta.persistence.*;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.models.Comment;
import pe.edu.pe.onlinebooks.models.User;

import java.time.LocalDateTime;

public class CommentDTO {
    public Integer id;
    public String content;
    public Integer userId;
    public LocalDateTime createdAt;

    public CommentDTO() {
    }

    public CommentDTO(Comment comment) {
        this.setId(comment.getId());
        this.setContent(comment.getContent());
        if(comment.getUser() != null) {
            this.setUserId(comment.getUser().getId());
        }
        this.setCreatedAt(comment.getCreatedAt());
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
