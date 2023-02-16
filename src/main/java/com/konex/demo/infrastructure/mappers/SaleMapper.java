package com.konex.demo.infrastructure.mappers;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.request.SaleRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.application.response.SaleResponse;

public class SaleMapper {

  public static SaleResponse toResponse(SaleRequest target) {
    return SaleResponse.builder()
        .fecha(target.getFecha())
        .hora(target.getHora())
        .valorTotal(target.getValorTotal())
        .idMedicamento(target.getIdMedicamento())
        .valorUnitario(target.getValorUnitario())
        .build();
  }

  public static SaleRequest toRequest(SaleResponse target) {
    return SaleRequest.builder()
        .fecha(target.getFecha())
        .hora(target.getHora())
        .valorTotal(target.getValorTotal())
        .idMedicamento(target.getIdMedicamento())
        .valorUnitario(target.getValorUnitario())
        .build();
  }

}
