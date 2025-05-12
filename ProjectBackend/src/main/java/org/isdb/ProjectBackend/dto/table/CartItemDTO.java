package org.isdb.ProjectBackend.dto.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartItemDTO {

    private Long cartItemID;
    private Long cartID;
    private Long  bookID;
    private Integer quantity;
    private BigDecimal priceAtAddTime;
    private LocalDateTime addedAt;
}
