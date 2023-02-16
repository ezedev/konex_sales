package com.konex.demo.domain.service;

import com.konex.demo.application.request.SaleRequest;
import com.konex.demo.application.response.SaleResponse;

@FunctionalInterface
public interface GenerateNewSale {

  public SaleResponse execute(SaleRequest saleRequest);

}
