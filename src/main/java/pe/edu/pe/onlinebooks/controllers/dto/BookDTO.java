package pe.edu.pe.onlinebooks.controllers.dto;

import jakarta.persistence.*;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.models.Comment;

import java.time.LocalDateTime;
import java.util.List;

public class BookDTO {
    public Integer id;
    public String title;
    public String author;
    public String genre;
    public String description;
    public String imageUrl;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public List<CommentDTO> comments;

    public BookDTO() {
    }

    public BookDTO(Book book) {
        this.setId(book.getId());
        this.setTitle(book.getTitle());
        this.setAuthor(book.getAuthor());
        this.setGenre(book.getGenre());
        this.setDescription(book.getDescription());
        this.setImageUrl(book.getImageUrl());
        this.setCreatedAt(book.getCreatedAt());
        this.setUpdatedAt(book.getUpdatedAt());

        this.setComments(book.getComments().stream().map(it -> new CommentDTO(it)).toList());

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}
