package com.telra.belarus.gym.repository;

import com.telra.belarus.gym.models.Gym;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Boris on 12.06.2017.
 */
public interface GymRepository extends MongoRepository<Gym, String> {
    Gym findGymByGymLogin(String gymLogin);
    Gym findGymByGymId(String gymId);
}
