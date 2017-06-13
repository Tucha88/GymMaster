package com.telra.belarus.gym.controllers;

import com.telra.belarus.gym.models.Client;
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
    public ResponseEntity<Object> login(@RequestBody Client authType){
        if (utils.isLoginInfoExist(authType)) {
            return new ResponseEntity<>("Error, there is no auth info", HttpStatus.UNAUTHORIZED);
        } else if (clientRepository.findClientByClientEmail(authType.getClientEmail()) != null) {
            Client client = clientRepository.findClientByClientEmail(authType.getClientEmail());
            if (!utils.isPasswordCorrect(authType.getClientPassword(), client.getClientPassword())) {
                return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
            }
            Token tokenAndBoolean = new Token();
            tokenAndBoolean.setToken(utils.getToken(client.getClientEmail(), client.getClientId()));
            return new ResponseEntity<>(tokenAndBoolean, HttpStatus.OK);

        }
        return new ResponseEntity<>("Please register",HttpStatus.UNAUTHORIZED);
    }

}