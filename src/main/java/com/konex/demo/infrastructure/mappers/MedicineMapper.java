package com.konex.demo.infrastructure.mappers;

import com.konex.demo.application.request.MedicineRequest;
import com.konex.demo.application.response.MedicineResponse;

public class MedicineMapper {




  public static MedicineResponse toResponse(MedicineRequest target) {
    var response = new MedicineResponse();
    response.setDueDate(target.getDueDate());
    response.setId(target.getId());
    response.setUnitValue(target.getUnitValue());
    response.setFactoryLaboratory(target.getFactoryLaboratory());
    response.setStock(target.getStock());
    response.setCreationDate(target.getCreationDate());
    return response;
  }

  public static MedicineRequest toRequest(MedicineResponse source) {
    var request = new MedicineRequest();
    request.setDueDate(source.getDueDate());
    request.setId(source.getId());
    request.setUnitValue(source.getUnitValue());
    request.setFactoryLaboratory(source.getFactoryLaboratory());
    request.setStock(source.getStock());
    request.setCreationDate(source.getCreationDate());
    return request;
  }
}
