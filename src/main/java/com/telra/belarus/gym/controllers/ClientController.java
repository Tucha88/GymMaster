package com.telra.belarus.gym.controllers;

import com.telra.belarus.gym.models.Client;
import com.telra.belarus.gym.repository.ClientRepository;
import com.telra.belarus.gym.repository.GymRepository;
import com.telra.belarus.gym.utils.IUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Boris on 13.06.2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {
    private final ClientRepository clientRepository;
    private final IUtils utils;
    private final GymRepository gymRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository, IUtils utils, GymRepository gymRepository) {
        this.clientRepository = clientRepository;
        this.utils = utils;
        this.gymRepository = gymRepository;
    }



    @GetMapping("getClient")
    public ResponseEntity<Object> get(){
        Client client = new Client();
        Calendar c = Calendar.getInstance();
        client.setClientBDay(c.getTime());
        client.setClientEmail("test@test.com");
        client.setClientPassword("1");
        client.setClientPhoneNumber("+972");
        client.setRegDate(c.getTime());
        clientRepository.save(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
