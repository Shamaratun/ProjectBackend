package org.isdb.ProjectBackend.dto.table;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDTO {

	private Integer discountID;
	private String name;
	private String description;
	private BigDecimal discountPercentage;
	private LocalDate startDate;
	private LocalDate endDate;
	private String criteria;

}