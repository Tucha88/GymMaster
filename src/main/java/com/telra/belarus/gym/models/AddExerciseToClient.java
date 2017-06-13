package com.telra.belarus.gym.models;

/**
 * Created by Boris on 12.06.2017.
 */
public class AddExerciseToClient {
    private String clientId;
    private Exercise exercise;

    public AddExerciseToClient() {
    }

    public AddExerciseToClient(String clientId, Exercise exercise) {
        this.clientId = clientId;
        this.exercise = exercise;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
