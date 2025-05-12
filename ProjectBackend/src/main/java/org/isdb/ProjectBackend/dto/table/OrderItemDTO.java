package org.isdb.ProjectBackend.dto.table;



import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long orderItemID;
    private Integer quantity;
    private BigDecimal price;
    private Long orderID;
    private Long bookID;
}

