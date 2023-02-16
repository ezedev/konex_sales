package com.konex.demo.infrastructure.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class SaleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String fecha;

  @Column
  private String hora;

  //aca podria hacer ManyToOne
  @Column
  private Long idMedicamento;

  @Column
  private Integer cantidad;

  @Column
  private BigDecimal valorUnitario;

  @Column
  private BigDecimal valorTotal;
}
