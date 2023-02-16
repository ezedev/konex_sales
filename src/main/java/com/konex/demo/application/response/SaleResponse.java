package com.konex.demo.application.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SaleResponse {

  private Long id;

  private String fecha;
  private String hora;

  private Long idMedicamento;

  private Integer cantidad;

  private BigDecimal valorUnitario;

  private BigDecimal valorTotal;
}
