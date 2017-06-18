package com.telra.belarus.gym.models;

import java.util.ArrayList;

/**
 * Created by Boris on 17.06.2017.
 */
public class ArrayExerciseToClient {
    private String clientId;
    private String exerciseName;
    private String type;
    private String nameOfTrainer;
    private String description;
    private ArrayList<Exercise> exercise = new ArrayList();

    public ArrayExerciseToClient() {
    }

    public ArrayExerciseToClient(String clientId, String exerciseName, String type, String nameOfTrainer, String description, ArrayList<Exercise> exercise) {

        this.clientId = clientId;
        this.exerciseName = exerciseName;
        this.type = type;
        this.nameOfTrainer = nameOfTrainer;
        this.description = description;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameOfTrainer() {
        return nameOfTrainer;
    }

    public void setNameOfTrainer(String nameOfTrainer) {
        this.nameOfTrainer = nameOfTrainer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Exercise> getExercise() {
        return exercise;
    }

    public void setExercise(ArrayList<Exercise> exercise) {
        this.exercise = exercise;
    }
}
