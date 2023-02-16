package com.konex.demo.domain.useCase;

import java.util.Objects;

import com.konex.demo.application.client.FeignClientMedicines;
import com.konex.demo.application.request.SaleRequest;
import com.konex.demo.application.response.SaleResponse;
import com.konex.demo.domain.service.GenerateNewSale;
import com.konex.demo.infrastructure.mappers.MedicineMapper;
import com.konex.demo.infrastructure.mappers.SaleMapper;
import org.springframework.stereotype.Service;

@Service
public class GenerateNewSaleUseCase implements GenerateNewSale {

  private final FeignClientMedicines feignClientMedicines;

  public GenerateNewSaleUseCase(FeignClientMedicines feignClientMedicines) {
    this.feignClientMedicines = feignClientMedicines;
  }

  @Override
  public SaleResponse execute(SaleRequest saleRequest) {
    var response = feignClientMedicines.getAllMedicines();

    var medicine = response.getBody()
        .stream()
        .filter(m -> Objects.equals(m.getId(), saleRequest.getIdMedicamento()))
        .findFirst();
    if (medicine.isPresent()) {
      feignClientMedicines.updateStockMedicine(MedicineMapper.toRequest(medicine.get()), saleRequest.getIdMedicamento());
    }

    //hardcodeado, tendria que ir el repository para la insertar en la base de datos

    return SaleMapper.toResponse(saleRequest);
  }
}
