package org.isdb.ProjectBackend.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Only for authorId
	private Long authorId;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 500)
	private String bio;

	@Column(nullable = false, length = 100)
	private String country;

	@Column(nullable = false, length = 100)
	private Date dob;

	@OneToMany(mappedBy = "author")
	@JsonManagedReference(value = "book-author")
	private List<Books> books;
}
