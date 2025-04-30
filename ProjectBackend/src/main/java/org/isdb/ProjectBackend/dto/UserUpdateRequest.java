package org.isdb.ProjectBackend.dto;

import org.isdb.ProjectBackend.constants.Role;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

public record UserUpdateRequest(@Email(message = "Email should be valid")

	    String fullName,
	    String email,
	    String address,
	    String nid,
	    String phoneNumber,
	    Role role // nullable, optional update for admins
	)
 {

	
}
