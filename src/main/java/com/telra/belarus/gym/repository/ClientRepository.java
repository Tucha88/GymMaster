package com.telra.belarus.gym.repository;

import com.telra.belarus.gym.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Boris on 11.06.2017.
 */

public interface ClientRepository extends MongoRepository<Client, String> {

    Client findClientByClientEmail(String email);
    Client findClientByClientId(String clientId);
}
