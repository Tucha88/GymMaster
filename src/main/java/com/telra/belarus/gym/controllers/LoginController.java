package com.telra.belarus.gym.controllers;

import com.telra.belarus.gym.models.AuthType;
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
@RequestMapping("/login")
public class LoginController {
    private final ClientRepository clientRepository;
    private final IUtils utils;
    private final GymRepository gymRepository;

    @Autowired
    public LoginController(ClientRepository clientRepository, IUtils utils, GymRepository gymRepository) {
        this.clientRepository = clientRepository;
        this.utils = utils;
        this.gymRepository = gymRepository;

    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthType authType) {
        if (clientRepository.findClientByClientEmail(authType.getEmial()) != null) {
            Client client = clientRepository.findClientByClientEmail(authType.getEmial());
            if (!utils.isPasswordCorrect(authType.getPassword(), client.getClientPassword())) {
                return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
            }
            Token tokenAndBoolean = new Token();
            tokenAndBoolean.setToken(utils.getToken(client.getClientEmail(), client.getClientId()));
            tokenAndBoolean.setId(client.getClientId());
            tokenAndBoolean.setState("Client");
            return new ResponseEntity<>(tokenAndBoolean, HttpStatus.OK);
        }
        if (gymRepository.findGymByGymLogin(authType.getEmial()) != null) {
            Gym gym = gymRepository.findGymByGymLogin(authType.getEmial());

            if (utils.isPasswordCorrect(authType.getPassword(), gym.getGymPassword())) {
                Token tokent = new Token();
                tokent.setToken(utils.getToken(gym.getGymLogin(), gym.getGymId()));
                tokent.setId(gym.getGymId());
                tokent.setState("Gym");
                return new ResponseEntity<>(tokent, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>("wrong password", HttpStatus.CONFLICT);
            }

        }
        return new ResponseEntity<>("Please register", HttpStatus.UNAUTHORIZED);
    }

}
