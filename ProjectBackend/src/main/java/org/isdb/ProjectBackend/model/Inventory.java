package org.isdb.ProjectBackend.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long inventoryId;

	private Integer quantity;

	@Column(name = "lastUpdated")
	private LocalDateTime lastUpdated;

	@ManyToOne
	@JoinColumn(name = "bookId")
	@JsonBackReference(value = "inventory-book")
	private Books book;

	@ManyToOne
	@JoinColumn(name = "warehouseId")
	@JsonBackReference(value = "inventory-warehouse")
	private Warehouse warehouse;
}
