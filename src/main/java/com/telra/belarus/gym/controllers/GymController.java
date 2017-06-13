package com.telra.belarus.gym.controllers;

import com.telra.belarus.gym.models.AddExerciseToClient;
import com.telra.belarus.gym.models.Exercise;
import com.telra.belarus.gym.repository.ClientRepository;
import com.telra.belarus.gym.repository.GymRepository;
import com.telra.belarus.gym.utils.IUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Boris on 12.06.2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/gym")
public class GymController {

    private final ClientRepository clientRepository;
    private final IUtils utils;
    private final GymRepository gymRepository;

    @Autowired
    public GymController(ClientRepository clientRepository, IUtils utils, GymRepository gymRepository) {
        this.clientRepository = clientRepository;
        this.utils = utils;
        this.gymRepository = gymRepository;
    }

    @PostMapping("addExercise")
    public ResponseEntity<Object> addExerciseToClient(@RequestBody AddExerciseToClient add){

        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<Object> get(){
        AddExerciseToClient addExerciseToClient = new AddExerciseToClient();
        Exercise exercise = new Exercise();
        addExerciseToClient.setExercise(exercise);
        return new ResponseEntity<Object>(addExerciseToClient,HttpStatus.OK);
    }



}
