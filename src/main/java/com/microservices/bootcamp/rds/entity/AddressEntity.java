package com.microservices.bootcamp.rds.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String zip;

    @Column(nullable = false)
    private String city;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "clients_address",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "client-id")
    )
    private Set<ClientEntity> clients = new HashSet<>();

    public void addClient(ClientEntity clientEntity) {
        this.clients.add(clientEntity);
    }

    public void removeClient(ClientEntity clientEntity) {
        this.clients.remove(clientEntity);
    }
}
