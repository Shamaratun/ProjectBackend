package org.isdb.ProjectBackend.model;

import java.security.Timestamp;

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

	private Long inventoryID;

	private Integer quantity;

	@Column(name = "lastUpdated")
	private Timestamp lastUpdated;

	@ManyToOne
	@JoinColumn(name = "bookID")
	private Books book;

	@ManyToOne
	@JoinColumn(name = "warehouseID")
	private Warehouse warehouse;
}
