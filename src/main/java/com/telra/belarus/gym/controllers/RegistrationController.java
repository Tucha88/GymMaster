package com.telra.belarus.gym.controllers;

import com.telra.belarus.gym.models.Client;
import com.telra.belarus.gym.models.Gym;
import com.telra.belarus.gym.models.Token;
import com.telra.belarus.gym.repository.ClientRepository;
import com.telra.belarus.gym.repository.GymRepository;
import com.telra.belarus.gym.utils.IUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Boris on 11.06.2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegistrationController {
    private final ClientRepository clientRepository;
    private final IUtils utils;
    private final GymRepository gymRepository;

    @Autowired
    public RegistrationController(ClientRepository clientRepository, IUtils utils, GymRepository gymRepository) {
        this.clientRepository = clientRepository;
        this.utils = utils;
        this.gymRepository = gymRepository;
    }

    @PostMapping("client")
    public ResponseEntity<Object> registerClient(@RequestBody Client client) {
        if (utils.isLoginInfoExist(client)) {
            return new ResponseEntity<>("Enter correct login or password", HttpStatus.CONFLICT);// Wrong login or password
        } else if (clientRepository.findClientByClientEmail(client.getClientEmail()) != null) {
            return new ResponseEntity<>("This user already exists", HttpStatus.CONFLICT); // Found same login
        }
        Gym gym = gymRepository.findGymByGymId(client.getGymId());
//        gym.addClient(client.getClientId());
        String str = utils.hashPassword(client.getClientPassword());
        client.setClientPassword(str);
        clientRepository.save(client);
        Token token = new Token();
        token.setToken(utils.getToken(client.getClientEmail(), client.getClientId()));

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("gym")
    public ResponseEntity<Object> registerGym(@RequestBody Gym gym) {
         if (gymRepository.findGymByGymLogin(gym.getGymLogin()) != null) {
            return new ResponseEntity<>("This user already exists", HttpStatus.CONFLICT); // Found same login
        }
        String str = utils.hashPassword(gym.getGymPassword());
        gym.setGymPassword(str);
        gymRepository.save(gym);
        Token token = new Token();
        token.setToken(utils.getToken(gym.getGymLogin(), gym.getGymId()));

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}