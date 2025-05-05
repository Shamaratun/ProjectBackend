package org.isdb.ProjectBackend.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer warehouseID;

	private String location;
	private Integer stockLevel;

//    @OneToMany(mappedBy = "warehouse")
//    private List<Books> books;
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Books> books;

	// @OneToMany(mappedBy = "warehouse")
	// private List<Inventory> inventories;
}
