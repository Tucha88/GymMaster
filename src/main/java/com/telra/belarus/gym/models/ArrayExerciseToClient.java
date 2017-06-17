package com.telra.belarus.gym.models;

import java.util.ArrayList;

/**
 * Created by Boris on 17.06.2017.
 */
public class ArrayExerciseToClient {
    private String clientId;
    private ArrayList<Exercise> exercise = new ArrayList();

    public ArrayExerciseToClient() {
    }

    public ArrayExerciseToClient(String clientId, ArrayList<Exercise> exercise) {

        this.clientId = clientId;
        this.exercise = exercise;
    }

    public String getClientId() {

        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ArrayList<Exercise> getExercise() {
        return exercise;
    }

    public void setExercise(ArrayList<Exercise> exercise) {
        this.exercise = exercise;
    }
}
