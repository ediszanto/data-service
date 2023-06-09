/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.model.Client;
import com.microservices.bootcamp.rds.model.FileUploadResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-04T10:43:56.443672+03:00[Europe/Bucharest]")
@Validated
@Tag(name = "clients", description = "Clients of your organisation")
public interface ClientsApi {

    default ClientsApiDelegate getDelegate() {
        return new ClientsApiDelegate() {};
    }

    /**
     * GET /clients/{clientId} : Find client by id
     *
     * @param clientId  (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Client not found (status code 404)
     */
    @Operation(
        operationId = "clientsClientIdGet",
        summary = "Find client by id",
        tags = { "clients" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Client not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/clients/{clientId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Client> clientsClientIdGet(
        @Parameter(name = "clientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("clientId") Long clientId
    ) {
        return getDelegate().clientsClientIdGet(clientId);
    }


    /**
     * PUT /clients/{clientId} : Update existing client
     *
     * @param clientId  (required)
     * @param client Client object to be updated (required)
     * @return Client Updated (status code 200)
     *         or Bad Request (status code 400)
     */
    @Operation(
        operationId = "clientsClientIdPut",
        summary = "Update existing client",
        tags = { "clients" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Client Updated", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/clients/{clientId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Client> clientsClientIdPut(
        @Parameter(name = "clientId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("clientId") Long clientId,
        @Parameter(name = "Client", description = "Client object to be updated", required = true) @Valid @RequestBody Client client
    ) {
        return getDelegate().clientsClientIdPut(clientId, client);
    }


    /**
     * POST /clients/fileUpload : Upload incremental client updates via csv file
     *
     * @param file  (optional)
     * @return successful operation (status code 200)
     *         or Bad Request (status code 400)
     */
    @Operation(
        operationId = "clientsFileUploadPost",
        summary = "Upload incremental client updates via csv file",
        tags = { "clients" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = FileUploadResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/clients/fileUpload",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    default ResponseEntity<FileUploadResponse> clientsFileUploadPost(
        @Parameter(name = "file", description = "") @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        return getDelegate().clientsFileUploadPost(file);
    }


    /**
     * POST /clients : Add a new Client
     *
     * @param client New Client Object (required)
     * @return Client Created (status code 201)
     *         or Bad Request (status code 400)
     */
    @Operation(
        operationId = "clientsPost",
        summary = "Add a new Client",
        tags = { "clients" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Client Created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/clients",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Client> clientsPost(
        @Parameter(name = "Client", description = "New Client Object", required = true) @Valid @RequestBody Client client
    ) {
        return getDelegate().clientsPost(client);
    }

}
