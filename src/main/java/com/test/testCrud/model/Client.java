package com.test.testCrud.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_birth")
    private String dateOfBirth;

    @Column(name = "inn")
    private String INN;

    @Column(name = "family_status")
    private String familyStatus;

    @Column(name = "vip_role")
    private boolean isVip;

    @OneToMany(mappedBy = "clientId")
    private Set<FamilyTable> families;

    public Client() {
    }

    public Client(String firstName, String lastName, String dateOfBirth, String INN, String familyStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.INN = INN;
        this.familyStatus = familyStatus;
        this.isVip = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public Set<FamilyTable> getFamilies() {
        return families;
    }

    public void setFamilies(Set<FamilyTable> families) {
        this.families = families;
    }
}

