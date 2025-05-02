package org.isdb.ProjectBackend.dto;

import org.isdb.ProjectBackend.constants.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	private Long id;

	private String email;
	private Role role;
	private String address;
	private Long nid;
	private String phoneNumber;
	private String fullName;
	private String username;
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;

}