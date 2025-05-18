package org.isdb.ProjectBackend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "Warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long warehouseId;

	@Column(nullable = false, length = 100)
	private String location;

	private Integer stockLevel;

	@OneToMany(mappedBy = "warehouse")
	@JsonManagedReference(value = "book-warehouse")
	private List<Books> books;

	@OneToMany(mappedBy = "warehouse")
	@JsonManagedReference(value = "inventory-warehouse")
	private List<Inventory> inventories;

}
