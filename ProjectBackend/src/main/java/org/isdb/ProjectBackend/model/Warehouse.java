package org.isdb.ProjectBackend.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Warehouse")
public class Warehouse {
	@Id
	private Integer warehouseID;

	private String location;
	private Integer stockLevel;

	@OneToMany(mappedBy = "warehouse")
	private List<Book> books;

	@OneToMany(mappedBy = "warehouse")
	private List<Inventory> inventories;
}
