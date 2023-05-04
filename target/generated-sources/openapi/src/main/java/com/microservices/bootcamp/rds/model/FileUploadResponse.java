package com.microservices.bootcamp.rds.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * FileUploadResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-04T10:43:56.443672+03:00[Europe/Bucharest]")
public class FileUploadResponse {

  @JsonProperty("recordsProcessedCount")
  private Integer recordsProcessedCount;

  public FileUploadResponse recordsProcessedCount(Integer recordsProcessedCount) {
    this.recordsProcessedCount = recordsProcessedCount;
    return this;
  }

  /**
   * Get recordsProcessedCount
   * @return recordsProcessedCount
  */
  
  @Schema(name = "recordsProcessedCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getRecordsProcessedCount() {
    return recordsProcessedCount;
  }

  public void setRecordsProcessedCount(Integer recordsProcessedCount) {
    this.recordsProcessedCount = recordsProcessedCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileUploadResponse fileUploadResponse = (FileUploadResponse) o;
    return Objects.equals(this.recordsProcessedCount, fileUploadResponse.recordsProcessedCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recordsProcessedCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileUploadResponse {\n");
    sb.append("    recordsProcessedCount: ").append(toIndentedString(recordsProcessedCount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

