package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.model.Contract;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-04T10:43:56.443672+03:00[Europe/Bucharest]")
@Controller
@RequestMapping("${openapi.referenceDataService.base-path:/v1}")
public class ContractsApiController implements ContractsApi {

    private final ContractsApiDelegate delegate;

    public ContractsApiController(@Autowired(required = false) ContractsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ContractsApiDelegate() {});
    }

    @Override
    public ContractsApiDelegate getDelegate() {
        return delegate;
    }

}
