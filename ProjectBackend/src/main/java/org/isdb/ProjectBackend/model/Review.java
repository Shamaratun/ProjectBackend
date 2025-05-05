package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reviewID;

    private Integer rating;
    private String comment;
    private LocalDateTime reviewDate;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book book;
}