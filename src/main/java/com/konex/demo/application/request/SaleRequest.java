package com.konex.demo.application.request;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaleRequest {

  private String fecha;
  private String hora;

  private Long idMedicamento;

  private Integer cantidad;

  private BigDecimal valorUnitario;

  private BigDecimal valorTotal;


}
