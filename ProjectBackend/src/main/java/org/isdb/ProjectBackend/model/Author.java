package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorID;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String bio;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, length = 100)
    private Date dob;

 @OneToMany(mappedBy = "author")
	private List<Books> books;
}
