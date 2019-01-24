package com.test.testCrud.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.testCrud.dao.ClientDAO;
import com.test.testCrud.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    private Gson gson = new GsonBuilder().create();

    @Autowired
    private ClientDAO clientDAO;

    @CrossOrigin
    @RequestMapping(
            path = "addclient",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName,
                                        @RequestParam("dateOfBirth") String dateOfBirth,
                                        @RequestParam("INN") String INN,
                                        @RequestParam("familyStatus") String familyStatus,
                                        @RequestParam("isVip") String isVip) {

        clientDAO.save(new Client(firstName, lastName, dateOfBirth, INN, familyStatus));
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @RequestMapping(
            path = "getclients",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getclients() {
        List<Client> all = clientDAO.findAll();
        return ResponseEntity.ok().body(gson.toJson(all));
    }

    @RequestMapping(
            path = "deleteclient",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity delete(@RequestParam("id") int id) {
        clientDAO.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
