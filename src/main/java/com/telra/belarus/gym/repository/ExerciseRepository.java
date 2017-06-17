package com.telra.belarus.gym.repository;

/**
 * Created by Boris on 17.06.2017.
 */

import com.telra.belarus.gym.models.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {
}
