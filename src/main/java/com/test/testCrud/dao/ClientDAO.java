package com.test.testCrud.dao;

import com.test.testCrud.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<Client, Integer> {

}
