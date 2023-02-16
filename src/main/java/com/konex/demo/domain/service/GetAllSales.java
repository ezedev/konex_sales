package com.konex.demo.domain.service;

import java.util.List;

import com.konex.demo.application.response.SaleResponse;

@FunctionalInterface
public interface GetAllSales {

  public List<SaleResponse> execute();

}
