package com.telra.belarus.gym.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Boris on 11.06.2017.
 */
@Document(collection = "client_test")
public class Client implements Serializable {
    private static final long serialVersionUID = -123456789L;


    @Id
    private String clientId;
    private String clientEmail;
    private String clientPassword;
    private Date clientBDay;
    private String clientPhoto;
    private String clientPhoneNumber;
    private String gender;
    private Date regDate;
    private String gymId;
    private ArrayList<ArrayExerciseToClient> exerciseToClients = new ArrayList<>();
    private ArrayList<Exercise> personalExercises = new ArrayList<>();

    public Client() {
    }

    public Client(String clientId, String clientEmail, String clientPassword,
                  Date clientBDay, String clientPhoto, String clientPhoneNumber,
                  String gender, Date regDate, String gymId,
                  ArrayList<ArrayExerciseToClient> exerciseToClients, ArrayList<Exercise> personalExercises) {
        this.clientId = clientId;
        this.clientEmail = clientEmail;
        this.clientPassword = clientPassword;
        this.clientBDay = clientBDay;
        this.clientPhoto = clientPhoto;
        this.clientPhoneNumber = clientPhoneNumber;
        this.gender = gender;
        this.regDate = regDate;
        this.gymId = gymId;
        this.exerciseToClients = exerciseToClients;
        this.personalExercises = personalExercises;
    }

    public void addToArray(ArrayExerciseToClient arrayExerciseToClient) {
        exerciseToClients.add(arrayExerciseToClient);
    }

    public ArrayList<ArrayExerciseToClient> getExerciseToClients() {
        return exerciseToClients;
    }

    public void setExerciseToClients(ArrayList<ArrayExerciseToClient> exerciseToClients) {
        this.exerciseToClients = exerciseToClients;
    }

    public String getClientId() {

        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void addExercise(Exercise exercise) {
        this.personalExercises.add(exercise);
    }

    public ArrayList<Exercise> getPersonalExercises() {
        return personalExercises;
    }

    public void setPersonalExercises(ArrayList<Exercise> personalExercises) {
        this.personalExercises = personalExercises;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public Date getClientBDay() {
        return clientBDay;
    }

    public void setClientBDay(Date clientBDay) {
        this.clientBDay = clientBDay;
    }

    public String getClientPhoto() {
        return clientPhoto;
    }

    public void setClientPhoto(String clientPhoto) {
        this.clientPhoto = clientPhoto;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }
}
