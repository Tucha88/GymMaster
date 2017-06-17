package com.telra.belarus.gym.models;

import java.util.ArrayList;

/**
 * Created by Boris on 17.06.2017.
 */
public class ArrayExerciseToClient {
    private String clientId;
    private String exerciseName;
    private String nameOfTrainer;
    private ArrayList<Exercise> exercise = new ArrayList();

    public ArrayExerciseToClient() {
    }

    public ArrayExerciseToClient(String clientId, String exerciseName, String nameOfTrainer, ArrayList<Exercise> exercise) {

        this.clientId = clientId;
        this.exerciseName = exerciseName;
        this.nameOfTrainer = nameOfTrainer;
        this.exercise = exercise;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getNameOfTrainer() {
        return nameOfTrainer;
    }

    public void setNameOfTrainer(String nameOfTrainer) {
        this.nameOfTrainer = nameOfTrainer;
    }

    public ArrayList<Exercise> getExercise() {
        return exercise;
    }

    public void setExercise(ArrayList<Exercise> exercise) {
        this.exercise = exercise;
    }
}
