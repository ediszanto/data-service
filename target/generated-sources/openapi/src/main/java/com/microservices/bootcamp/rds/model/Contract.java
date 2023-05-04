package com.microservices.bootcamp.rds.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.microservices.bootcamp.rds.model.Service;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Contract
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-04T10:43:56.443672+03:00[Europe/Bucharest]")
public class Contract {

  @JsonProperty("contractId")
  private Long contractId;

  @JsonProperty("contractDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate contractDate;

  @JsonProperty("services")
  @Valid
  private Set<Service> services = new LinkedHashSet<>();

  public Contract contractId(Long contractId) {
    this.contractId = contractId;
    return this;
  }

  /**
   * Get contractId
   * @return contractId
  */
  
  @Schema(name = "contractId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Long getContractId() {
    return contractId;
  }

  public void setContractId(Long contractId) {
    this.contractId = contractId;
  }

  public Contract contractDate(LocalDate contractDate) {
    this.contractDate = contractDate;
    return this;
  }

  /**
   * Get contractDate
   * @return contractDate
  */
  @NotNull @Valid 
  @Schema(name = "contractDate", requiredMode = Schema.RequiredMode.REQUIRED)
  public LocalDate getContractDate() {
    return contractDate;
  }

  public void setContractDate(LocalDate contractDate) {
    this.contractDate = contractDate;
  }

  public Contract services(Set<Service> services) {
    this.services = services;
    return this;
  }

  public Contract addServicesItem(Service servicesItem) {
    this.services.add(servicesItem);
    return this;
  }

  /**
   * Get services
   * @return services
  */
  @NotNull @Valid 
  @Schema(name = "services", requiredMode = Schema.RequiredMode.REQUIRED)
  public Set<Service> getServices() {
    return services;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setServices(Set<Service> services) {
    this.services = services;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contract contract = (Contract) o;
    return Objects.equals(this.contractId, contract.contractId) &&
        Objects.equals(this.contractDate, contract.contractDate) &&
        Objects.equals(this.services, contract.services);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contractId, contractDate, services);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contract {\n");
    sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
    sb.append("    contractDate: ").append(toIndentedString(contractDate)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
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

