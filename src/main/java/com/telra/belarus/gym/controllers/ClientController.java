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
            return new ResponseEntity<Object>("Ther is no client by this id", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Object>(client1, HttpStatus.OK);
    }
//    @PutMapping("client")
//    public ResponseEntity<Object> editClient(@RequestParam("id") String client,@RequestBody Client client2){
//
//        Client client1 = clientRepository.findOne(client);
//        if (client1 == null){
//            return new ResponseEntity<Object>("Ther is no client by this id",HttpStatus.CONFLICT);
//        }
//        client1.set
//        return new ResponseEntity<Object>(client1,HttpStatus.OK);
//    }

}
