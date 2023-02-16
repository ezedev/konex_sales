package com.konex.demo.domain.useCase;

import java.util.List;

import com.konex.demo.application.response.SaleResponse;
import com.konex.demo.domain.service.GetAllSales;
import org.springframework.stereotype.Service;

@Service
public class GetAllSalesUseCase implements GetAllSales {

  @Override
  public List<SaleResponse> execute() {
    return null;
  }
}
