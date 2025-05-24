
package org.isdb.ProjectBackend.dto.table;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartItemDTO {

	private Long cartItemId;
	private String cart;
	private String title;
	private String authorName;
	private Integer quantity;
	private BigDecimal priceAt;

}
