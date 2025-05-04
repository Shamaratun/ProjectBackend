package org.isdb.ProjectBackend.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
