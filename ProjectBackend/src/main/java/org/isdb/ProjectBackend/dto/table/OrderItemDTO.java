package org.isdb.ProjectBackend.dto.table;



import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Integer orderItemID;
    private Integer quantity;
    private BigDecimal price;
    private Integer orderID;
    private Integer bookID;
}

