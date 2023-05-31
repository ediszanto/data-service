package com.microservices.bootcamp.rds.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "clients")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false, unique = true)
    private Long clientId;

    @EqualsAndHashCode.Include
    @Column(name = "client_number", nullable = false, unique = true)
    private Long clientNumber;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Enumerated
    @Column(name = "type", nullable = false, length = 7)
    private String type;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "clients_address",
//            joinColumns = @JoinColumn(name = "clients_id"),
//            inverseJoinColumns =  @JoinColumn(name = "address_id")
//    )
//    private Set<AddressEntity> addresses = new HashSet<>();
//
//    public void addAddress(AddressEntity address) {
//        this.addresses.add(address);
//        address.getClients().add(this);
//    }
//
//    public void removeAddress(AddressEntity address) {
//        this.addresses.remove(address);
////        address.removeClient();
//    }
}
