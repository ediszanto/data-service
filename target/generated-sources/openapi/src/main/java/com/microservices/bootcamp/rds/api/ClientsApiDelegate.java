package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.model.Client;
import com.microservices.bootcamp.rds.model.FileUploadResponse;
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
 * A delegate to be called by the {@link ClientsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-04T10:43:56.443672+03:00[Europe/Bucharest]")
public interface ClientsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /clients/{clientId} : Find client by id
     *
     * @param clientId  (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Client not found (status code 404)
     * @see ClientsApi#clientsClientIdGet
     */
    default ResponseEntity<Client> clientsClientIdGet(Long clientId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"clientId\" : 0, \"address\" : \"address\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clients/{clientId} : Update existing client
     *
     * @param clientId  (required)
     * @param client Client object to be updated (required)
     * @return Client Updated (status code 200)
     *         or Bad Request (status code 400)
     * @see ClientsApi#clientsClientIdPut
     */
    default ResponseEntity<Client> clientsClientIdPut(Long clientId,
        Client client) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"clientId\" : 0, \"address\" : \"address\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clients/fileUpload : Upload incremental client updates via csv file
     *
     * @param file  (optional)
     * @return successful operation (status code 200)
     *         or Bad Request (status code 400)
     * @see ClientsApi#clientsFileUploadPost
     */
    default ResponseEntity<FileUploadResponse> clientsFileUploadPost(MultipartFile file) {
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
     * POST /clients : Add a new Client
     *
     * @param client New Client Object (required)
     * @return Client Created (status code 201)
     *         or Bad Request (status code 400)
     * @see ClientsApi#clientsPost
     */
    default ResponseEntity<Client> clientsPost(Client client) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"clientId\" : 0, \"address\" : \"address\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
