package com.telra.belarus.gym.controllers;

import com.telra.belarus.gym.models.Client;
import com.telra.belarus.gym.repository.ClientRepository;
import com.telra.belarus.gym.repository.GymRepository;
import com.telra.belarus.gym.utils.IUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("client")
    public ResponseEntity<Object> getClient(@RequestParam("id") String client) {
        Client client1 = clientRepository.findOne(client);
        if (client1 == null) {
            return new ResponseEntity<>("There is no client by this id", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(client1, HttpStatus.OK);
    }

    @GetMapping("exercises")
    public ResponseEntity<Object> getExercises(@RequestParam("id") String client) {
        Client client1 = clientRepository.findOne(client);
        if (client1 == null) {
            return new ResponseEntity<>("there no such client", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(client1.getExerciseToClients(), HttpStatus.OK);
    }

}
