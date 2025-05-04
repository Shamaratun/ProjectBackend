package org.isdb.ProjectBackend.dto.login;

import org.isdb.ProjectBackend.constants.Role;

import jakarta.validation.constraints.Email;

public record UserUpdateRequest(@Email(message = "Email should be valid")

String fullName, String email, String address, Long nid, String phoneNumber, Role role // nullable, optional update for
																						// admins
) {

}
