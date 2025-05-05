package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer discountID;

    private String name;
    private String description;
    private BigDecimal discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private String criteria;

    @OneToMany(mappedBy = "discount")
    private List<Order> orders;
}