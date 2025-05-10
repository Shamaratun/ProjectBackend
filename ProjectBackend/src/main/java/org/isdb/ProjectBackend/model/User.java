package org.isdb.ProjectBackend.model;

import java.time.LocalDateTime;
import java.util.List;

import org.isdb.ProjectBackend.constants.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_U")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String fullName;

	@Column(unique = true, nullable = false)
	private String email;

	@JsonIgnore
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	private String address;

	private Long nid;

	private String phoneNumber;

	@OneToMany
	private List<Review> reviews;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public User(String email, String password, Role role, String address, Long nid, String phoneNumber, String fullname,
			String username) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
		this.nid = nid;
		this.phoneNumber = phoneNumber;
		this.fullName = fullname;
		this.username = username;
	}

}
