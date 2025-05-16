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
public class ShippingDTO {
	private Long shippingId;
	private String name;
	private String phone;
	private String address;
	private String city;
	private String country;
	private String deliveryMethod;
	private String estimatedDeliveryTime;
	private BigDecimal shippingCost;
}