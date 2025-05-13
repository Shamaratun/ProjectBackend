

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

    private Long cartItemId;
    private Long cartId;
    private Long  bookId;
    private Integer quantity;
    private BigDecimal priceAtAddTime;
    private LocalDateTime addedAt;
}
