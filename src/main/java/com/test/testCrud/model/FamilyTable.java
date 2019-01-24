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


    public FamilyTable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public LastNames getFamilyId() {
        return familyId;
    }

    public void setFamilyId(LastNames familyId) {
        this.familyId = familyId;
    }
}
