package org.isdb.ProjectBackend.dto;

import lombok.Getter;
import lombok.Setter;
import org.isdb.ProjectBackend.constants.Role;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private Role role;
    private String address;
    private Integer nid;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}