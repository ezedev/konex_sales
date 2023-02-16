package com.konex.demo.application.client;

import java.util.List;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;
import com.konex.demo.infrastructure.ClientFeignConfiguration;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "medicine-client", url = "localhost:8080", configuration = ClientFeignConfiguration.class)
public interface FeignClientMedicines {

  @GetMapping(value = "/medicine/medicines", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<MedicineResponse>> getAllMedicines();

  @GetMapping(value = "/medicine/medicines/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public MedicineResponse getMedicineById(@PathVariable("id") Long id);

  @PutMapping(value = "/medicine/medicines/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateStockMedicine(@Param("id") MedicineRequest medicineRequest, @PathVariable Long id);

}
