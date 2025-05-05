package org.isdb.ProjectBackend.dto.login;

import org.isdb.ProjectBackend.constants.Role;

public record RegisterRequest(String email, String password, Role role, String address, Long nid, // or Integer nid if
                              // you kept that
                              String phoneNumber, String fullName, String username) {
}