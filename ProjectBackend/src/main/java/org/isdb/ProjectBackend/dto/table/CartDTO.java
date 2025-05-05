package org.isdb.ProjectBackend.dto.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartDTO {

    private Integer cartID;
    private LocalDateTime createdDate;
    private Integer userID; // Assuming User has userID

}