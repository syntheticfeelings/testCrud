package com.test.testCrud.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "family")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "family")
    private Set<Client> users = new HashSet<>();

    public Family() {
    }

    public Set<Client> getUsers() {
        return users;
    }

    public void setUsers(Set<Client> users) {
        this.users = users;
    }
}
