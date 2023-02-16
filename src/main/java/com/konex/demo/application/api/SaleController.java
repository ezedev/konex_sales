package com.konex.demo.application.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.konex.demo.application.request.SaleRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.application.response.SaleResponse;
import com.konex.demo.domain.service.GenerateNewSale;
import com.konex.demo.domain.service.GetAllSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sale")
@CrossOrigin(origins = {"http://localhost:3000", "*"})
public class SaleController {

  private final GenerateNewSale generateNewSaleUseCase;

  private final GetAllSales getAllSalesUseCase;

  public SaleController(GenerateNewSale generateNewSaleUseCase, GetAllSales getAllSalesUseCase) {
    this.generateNewSaleUseCase = generateNewSaleUseCase;
    this.getAllSalesUseCase = getAllSalesUseCase;
  }

  @GetMapping("/sales")
  public ResponseEntity<List<SaleResponse>> getAllSales() {

    var saleResponses = getAllSalesUseCase.execute();

    return new ResponseEntity<>(saleResponses, HttpStatus.OK);

  }

  @PostMapping("/sales")
  public ResponseEntity<?> create(@RequestBody SaleRequest saleRequest) {

    Map<String, Object> responseMessage = new HashMap<>();

    var responseObject = generateNewSaleUseCase.execute(saleRequest);

    responseMessage.put("sale", "la venta se creo con exito");
    responseMessage.put("sale", responseObject);
    return new ResponseEntity<Map<String, Object>>(responseMessage, HttpStatus.CREATED);
  }

  //para pruebas
  @GetMapping("/hola")
  public ResponseEntity<String> hola() {

    var responseObject = generateNewSaleUseCase.execute(SaleRequest.builder().build());

    return new ResponseEntity<>("hola", HttpStatus.OK);

  }
}
