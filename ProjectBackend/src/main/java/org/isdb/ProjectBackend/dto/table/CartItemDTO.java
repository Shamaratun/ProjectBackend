package org.isdb.ProjectBackend.dto.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    private Integer cartItemID;
    private Integer quantity;
    private Integer cartID; // Assuming Cart has getCartID() method
    private Integer bookID; // Assuming Books has getBookID() method

}
