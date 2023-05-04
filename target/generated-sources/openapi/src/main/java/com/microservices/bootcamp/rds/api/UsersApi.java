/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.microservices.bootcamp.rds.api;

import com.microservices.bootcamp.rds.model.User;
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
@Tag(name = "users", description = "the users API")
public interface UsersApi {

    default UsersApiDelegate getDelegate() {
        return new UsersApiDelegate() {};
    }

    /**
     * POST /users/{role} : add a new user
     *
     * @param role  (required)
     * @param user New uer object (required)
     * @return User created (status code 201)
     *         or Bad Request (status code 400)
     */
    @Operation(
        operationId = "usersRolePost",
        summary = "add a new user",
        tags = { "users" },
        responses = {
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/users/{role}",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> usersRolePost(
        @Parameter(name = "role", description = "", required = true, in = ParameterIn.PATH) @PathVariable("role") String role,
        @Parameter(name = "User", description = "New uer object", required = true) @Valid @RequestBody User user
    ) {
        return getDelegate().usersRolePost(role, user);
    }

}
