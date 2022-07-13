package com.devsuperior.dsmeta.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_sales")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sellerName;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;
}
