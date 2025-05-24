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

public class DiscountDTO {

	private Long discountId;

	private String name;

	private String description;

	private BigDecimal discountPercentage;

	private String criteria;

	private Long bookId;

	private String bookTitle;
}