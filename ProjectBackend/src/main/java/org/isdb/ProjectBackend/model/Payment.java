package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer paymentID;

    private String paymentMethod;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
    private String transactionStatus;

    @OneToOne(mappedBy = "payment")
    private Order order;
}
