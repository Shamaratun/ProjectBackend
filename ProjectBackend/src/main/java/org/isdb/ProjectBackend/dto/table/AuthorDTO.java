package org.isdb.ProjectBackend.dto.table;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

	private String name;
	private String bio;
	private String country;
	private Date dob;

}