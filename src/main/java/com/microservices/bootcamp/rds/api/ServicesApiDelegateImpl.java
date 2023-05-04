package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.model.FileUploadResponse;
import com.microservices.bootcamp.rds.model.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class ServicesApiDelegateImpl implements ServicesApiDelegate{
    @Override
    public ResponseEntity<FileUploadResponse> servicesFileUploadPost(MultipartFile file) {
        return ServicesApiDelegate.super.servicesFileUploadPost(file);
    }

    @Override
    public ResponseEntity<Service> servicesServiceIdGet(Long serviceId) {
        return ServicesApiDelegate.super.servicesServiceIdGet(serviceId);
    }
}
