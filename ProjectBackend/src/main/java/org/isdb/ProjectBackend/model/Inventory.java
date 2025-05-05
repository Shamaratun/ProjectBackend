//package org.isdb.ProjectBackend.model;
//
//import java.security.Timestamp;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "Inventory")
//public class Inventory {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)

//	private Integer inventoryID;
//
//	private Integer quantity;
//
//	@Column(name = "lastUpdated")
//	private Timestamp lastUpdated;
//
//	@ManyToOne
//	@JoinColumn(name = "bookID")
//	private Book book;
//
//	@ManyToOne
//	@JoinColumn(name = "warehouseID")
//	private Warehouse warehouse;
//}
