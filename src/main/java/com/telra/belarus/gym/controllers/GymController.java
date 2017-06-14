package com.telra.belarus.gym.controllers;

import com.telra.belarus.gym.models.AddExerciseToClient;
import com.telra.belarus.gym.models.Client;
import com.telra.belarus.gym.models.Exercise;
import com.telra.belarus.gym.models.Gym;
import com.telra.belarus.gym.repository.ClientRepository;
import com.telra.belarus.gym.repository.GymRepository;
import com.telra.belarus.gym.utils.IUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @Autowired
    public GymController(ClientRepository clientRepository, IUtils utils, GymRepository gymRepository) {
        this.clientRepository = clientRepository;
        this.utils = utils;
        this.gymRepository = gymRepository;
    }

    @PostMapping("addExercise")
    public ResponseEntity<Object> addExerciseToClient(@RequestParam("id") String gymId,@RequestBody AddExerciseToClient add){
       String s = gymId;
        Client client = clientRepository.findOne(add.getClientId());

        if (!client.getGymId().equals(gymId)){
            return new ResponseEntity<Object>("this is not your client",HttpStatus.CONFLICT);
        }
        if (client == null){
            return new ResponseEntity<>("Client not found",HttpStatus.CONFLICT);
        }
        client.addExercise(add.getExercise());
        clientRepository.save(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getGym")
    public ResponseEntity<Object> get(@RequestHeader("Id") String token,@RequestParam("id") String id){
        Gym gym = gymRepository.findOne(id);
        if(gym == null){
            return new ResponseEntity<Object>("Gym not found",HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(gym,HttpStatus.OK);
    }

/*
    @GetMapping("getexers")
    public ResponseEntity<Object> getExers(){
        Exercise exercise = new Exercise();
        exercise.setCategoryName("back");
        exercise.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        exercise.setExerciseName("Jimm");
        exercise.setTitle("Jimm");
        AddExerciseToClient addExerciseToClient = new AddExerciseToClient();
        addExerciseToClient.setExercise(exercise);
        addExerciseToClient.setClientId("594044193dd0cb2bf81c04f5");
        return new ResponseEntity<Object>(addExerciseToClient,HttpStatus.OK);
    }
*/

    @GetMapping("getallclients")
    public ResponseEntity<Object> getAllClients(@RequestParam("id")String id){
        Gym gym = gymRepository.findOne(id);
        if (gym == null){
            return new ResponseEntity<>("Gym not found, register please",HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(gym.getClients(),HttpStatus.OK);
    }

    @GetMapping("getallgyms")
    public ResponseEntity<Object> getAllGyms(){
        ArrayList<Gym> gyms = (ArrayList) gymRepository.findAll();
        List<String > strings = new ArrayList<>();
        for (int i = 0; i < gyms.size(); i++) {
            strings.add(gyms.get(i).getGymId());
        }
        return new ResponseEntity<Object>(strings,HttpStatus.OK);
    }

}
