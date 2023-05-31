package com.microservices.bootcamp.rds.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "contract")
public class ContractEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id", nullable = false, unique = true)
    private Long contractId;

    @Column(name = "contract_date")
    private Date contractDate;

    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToMany(
            mappedBy = "contract",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<ContractDetailsEntity> registrations = new HashSet<>();

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Set<ContractDetailsEntity> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<ContractDetailsEntity> registrations) {
        if (!this.registrations.isEmpty())  this.registrations.clear();
        this.registrations.addAll(registrations);
        registrations.forEach(r -> r.setContract(this));
    }
}
