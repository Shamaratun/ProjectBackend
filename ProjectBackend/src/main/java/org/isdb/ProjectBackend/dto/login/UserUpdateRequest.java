package org.isdb.ProjectBackend.dto.login;

import jakarta.validation.constraints.Email;
import org.isdb.ProjectBackend.constants.Role;

public record UserUpdateRequest(@Email(message = "Email should be valid")

                                String fullName, String email, String address, Long nid, String phoneNumber, Role role
                                // nullable, optional update for
                                // admins
) {

}
