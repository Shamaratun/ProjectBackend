package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "warehouse")
    private List<Books> books;


    // @OneToMany(mappedBy = "warehouse")
    // private List<Inventory> inventories;
}
