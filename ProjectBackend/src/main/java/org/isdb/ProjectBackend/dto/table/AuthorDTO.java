package org.isdb.ProjectBackend.dto.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Integer authorID;
    private String name;
    private String bio;
    private String country;
    private Date dob;

}