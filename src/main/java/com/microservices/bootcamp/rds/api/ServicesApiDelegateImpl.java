package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.exception.CsvFileReadException;
import com.microservices.bootcamp.rds.model.FileUploadResponse;
import com.microservices.bootcamp.rds.model.Service;
import com.microservices.bootcamp.rds.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@Component
@RequiredArgsConstructor
public class ServicesApiDelegateImpl implements ServicesApiDelegate{

    private final ServicesService servicesService;

    @Override
    public ResponseEntity<FileUploadResponse> servicesFileUploadPost(MultipartFile file) {
        FileUploadResponse result = new FileUploadResponse();
        try {
            long processedServicesCount = servicesService.servicesFileUploadPost(file);
            result.setRecordsProcessedCount((int) processedServicesCount);
        } catch (CsvFileReadException e) {
            return ResponseEntity.internalServerError().build();
        }
        return status(CREATED).body(result);
    }

    @Override
    public ResponseEntity<Service> servicesServiceIdGet(Long serviceId) {
        Service result = servicesService.servicesServiceCodeGet(serviceId);
        if (isNull(result)) return notFound().build();
        else return  ok(result);
    }

    @Override
    public ResponseEntity<List<Service>> servicesGet(Integer page, Integer size, String sort, String by) {
        List<Service> result = servicesService.servicesGet(page, size, sort, by);
        return  ok(result);
    }
}
