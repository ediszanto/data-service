package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.model.FileUploadResponse;
import com.microservices.bootcamp.rds.model.Service;
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
 * A delegate to be called by the {@link ServicesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-04T10:43:56.443672+03:00[Europe/Bucharest]")
public interface ServicesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /services/fileUpload : Upload incremental service updates via csv file
     *
     * @param file  (optional)
     * @return successful operation (status code 200)
     *         or Bad Request (status code 400)
     * @see ServicesApi#servicesFileUploadPost
     */
    default ResponseEntity<FileUploadResponse> servicesFileUploadPost(MultipartFile file) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"recordsProcessedCount\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /services : Get paginated and sorted services
     *
     * @param page  (required)
     * @param size  (required)
     * @param sort  (required)
     * @param by  (optional)
     * @return successful operation (status code 200)
     *         or Invalid pagination arguments (status code 400)
     * @see ServicesApi#servicesGet
     */
    default ResponseEntity<Service> servicesGet(Integer page,
        Integer size,
        String sort,
        String by) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unit\" : \"unit\", \"code\" : \"code\", \"price\" : 6.027456183070403, \"name\" : \"name\", \"vat\" : 1.4658129805029452, \"serviceId\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /services/{serviceId} : Find service by service id
     *
     * @param serviceId  (required)
     * @return successful operation (status code 200)
     *         or Service not found (status code 404)
     * @see ServicesApi#servicesServiceIdGet
     */
    default ResponseEntity<Service> servicesServiceIdGet(Long serviceId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unit\" : \"unit\", \"code\" : \"code\", \"price\" : 6.027456183070403, \"name\" : \"name\", \"vat\" : 1.4658129805029452, \"serviceId\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
