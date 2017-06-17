package com.telra.belarus.gym.controllers;

import com.telra.belarus.gym.models.*;
import com.telra.belarus.gym.repository.ClientRepository;
import com.telra.belarus.gym.repository.ExerciseRepository;
import com.telra.belarus.gym.repository.GymRepository;
import com.telra.belarus.gym.utils.IUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public GymController(ClientRepository clientRepository, IUtils utils, GymRepository gymRepository, ExerciseRepository exerciseRepository) {
        this.clientRepository = clientRepository;
        this.utils = utils;
        this.gymRepository = gymRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @PostMapping("addExercise")
    public ResponseEntity<Object> addExerciseToClient(@RequestParam("id") String gymId, @RequestBody AddExerciseToClient add) {
        String s = gymId;
        Client client = clientRepository.findOne(add.getClientId());

        if (!client.getGymId().equals(gymId)) {
            return new ResponseEntity<Object>("this is not your client", HttpStatus.CONFLICT);
        }
        if (client == null) {
            return new ResponseEntity<>("Client not found", HttpStatus.CONFLICT);
        }
        client.addExercise(add.getExercise());
        clientRepository.save(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("addlistExercise")
    public ResponseEntity<Object> addExerciseArrayToClient(@RequestParam("id") String gymId, @RequestBody ArrayExerciseToClient add) {
        String s = gymId;
        Client client = clientRepository.findOne(add.getClientId());

        if (!client.getGymId().equals(gymId)) {
            return new ResponseEntity<Object>("this is not your client", HttpStatus.CONFLICT);
        }
        if (client == null) {
            return new ResponseEntity<>("Client not found", HttpStatus.CONFLICT);
        }
        for (int i = 0; i < add.getExercise().size(); i++) {
            client.addExercise(add.getExercise().get(i));
        }

        clientRepository.save(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getGym")
    public ResponseEntity<Object> get(@RequestParam("id") String id) {
        Gym gym = gymRepository.findOne(id);
        if (gym == null) {
            return new ResponseEntity<Object>("Gym not found", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(gym, HttpStatus.OK);
    }


    @GetMapping("getallclients")
    public ResponseEntity<Object> getAllClients(@RequestParam("id") String id) {
        Gym gym = gymRepository.findOne(id);
        if (gym == null) {
            return new ResponseEntity<>("Gym not found, register please", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(gym.getClients(), HttpStatus.OK);
    }

    @GetMapping("getallgyms")
    public ResponseEntity<Object> getAllGyms() {
        ArrayList<Gym> gyms = (ArrayList) gymRepository.findAll();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < gyms.size(); i++) {
            strings.add(gyms.get(i).getGymId());
        }
        return new ResponseEntity<Object>(strings, HttpStatus.OK);
    }

    @PostMapping("exercise")
    public ResponseEntity<Object> addExercise(@RequestBody Exercise exercise) {
        if (exercise.getExerciseName() == null || exercise.getDescription() == null || exercise.getExerciseName().equals("") || exercise.getDescription().equals("")) {
            return new ResponseEntity<Object>("Fill in exercise info: name and description", HttpStatus.CONFLICT);
        }
        exerciseRepository.save(exercise);
        return new ResponseEntity<Object>(exercise.getExerciseId(), HttpStatus.OK);
    }


    @GetMapping("exercise")
    public ResponseEntity<Object> getExercises() {
        return new ResponseEntity<Object>(exerciseRepository.findAll(), HttpStatus.OK);
    }
}
