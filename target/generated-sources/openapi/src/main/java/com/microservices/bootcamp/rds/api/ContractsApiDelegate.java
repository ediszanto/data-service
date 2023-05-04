package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.model.Contract;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ContractsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-04T10:43:56.443672+03:00[Europe/Bucharest]")
public interface ContractsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /contracts/{contractId} : Update existing contract
     *
     * @param contractId  (required)
     * @param contract Contract object to be updated (required)
     * @return Contract Updated (status code 200)
     *         or Bad Request (status code 400)
     * @see ContractsApi#contractsContractIdPut
     */
    default ResponseEntity<Contract> contractsContractIdPut(Long contractId,
        Contract contract) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"contractDate\" : \"2000-01-23\", \"contractId\" : 0, \"services\" : [ { \"unit\" : \"unit\", \"code\" : \"code\", \"price\" : 6.027456183070403, \"name\" : \"name\", \"vat\" : 1.4658129805029452, \"serviceId\" : 0 }, { \"unit\" : \"unit\", \"code\" : \"code\", \"price\" : 6.027456183070403, \"name\" : \"name\", \"vat\" : 1.4658129805029452, \"serviceId\" : 0 } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
