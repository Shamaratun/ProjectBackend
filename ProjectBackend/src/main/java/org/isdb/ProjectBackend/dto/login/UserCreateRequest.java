package org.isdb.ProjectBackend.dto.login;

import org.isdb.ProjectBackend.constants.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
		@NotBlank(message = "Users fullName cannot be blank") @Size(min = 3, max = 20, message = "Users fullName must be between 3 and 20 characters") String fullName,

		@NotBlank(message = "Email cannot be blank") @Email(message = "Email should be valid") String email,

		@NotBlank(message = "Password cannot be blank") @Size(min = 6, message = "Password must be at least 6 characters") String password,

		@NotNull(message = "Role cannot be null") Role role,

		String address, Long nid, String phoneNumber) {
}
