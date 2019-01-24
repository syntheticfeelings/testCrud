package com.test.testCrud.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "familyTable")
public class FamilyTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @ManyToOne
    @JoinColumn(name = "lastnames_id")
    private LastNames familyId;


    @OneToMany(mappedBy = "family")
    private Set<Client> users = new HashSet<>();

    public FamilyTable() {
    }

    public Set<Client> getUsers() {
        return users;
    }

    public void setUsers(Set<Client> users) {
        this.users = users;
    }
}
