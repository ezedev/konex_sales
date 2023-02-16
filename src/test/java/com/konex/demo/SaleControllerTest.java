package com.konex.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.konex.demo.application.api.SaleController;
import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.request.SaleRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.application.response.SaleResponse;
import com.konex.demo.domain.service.GenerateNewSale;
import com.konex.demo.domain.service.GetAllSales;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

public class SaleControllerTest {

  @InjectMocks
  SaleController saleController;

  @Mock
  GetAllSales getAllSalesUseCase;

  @Mock
  GenerateNewSale generateNewSale;

  @BeforeEach
  public void init() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void get_all_sales() {

    var response = new ArrayList<SaleResponse>();
    response.add(SaleResponse.builder()
        .id(1L)
        .idMedicamento(1L).build());
    response.add(SaleResponse.builder()
        .id(2L)
        .idMedicamento(1L).build());

    response.add(SaleResponse.builder()
        .id(3L)
        .idMedicamento(1L).build());

    Mockito.when(getAllSalesUseCase.execute()).thenReturn(response);

    var result = saleController.getAllSales();

    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertEquals(3, result.getBody().size());

  }

  @Test
  public void given_requesto_to_create() {

    var response = SaleResponse.builder()
        .id(1L)
        .idMedicamento(1L)
        .build();
    var request = SaleRequest.builder()
        .idMedicamento(1L).build();

    Mockito.when(generateNewSale.execute(request)).thenReturn(response);

    var result = saleController.create(request);

    assertEquals(HttpStatus.CREATED, result.getStatusCode());

  }

}
