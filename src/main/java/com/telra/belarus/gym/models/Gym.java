package com.telra.belarus.gym.models;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Boris on 12.06.2017.
 */
public class Gym implements Serializable {
    private static final long serialVersionUID = -123456780L;

    @Id
    private String gymId;
    private String gymLogin;
    private String gymPassword;
    private String gymAddress;
    private ArrayList<String> gymPhoto;
    private String gymDescription;
    private String startWorkTime;
    private String endWorkTime;
    private ArrayList<String> clientIds;

    public Gym() {
    }

    public Gym(String gymId, String gymLogin, String gymPassword, String gymAddress, ArrayList<String> gymPhoto,
               String gymDescription, String startWorkTime, String endWorkTime, ArrayList<String> clients) {
        this.gymId = gymId;
        this.gymLogin = gymLogin;
        this.gymPassword = gymPassword;
        this.gymAddress = gymAddress;
        this.gymPhoto = gymPhoto;
        this.gymDescription = gymDescription;
        this.startWorkTime = startWorkTime;
        this.endWorkTime = endWorkTime;
        this.clientIds = clients;
    }

    public void addClient(String client){
        this.clientIds.add(client);
    }

    public String getGymId() {

        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    public ArrayList<String> getGymPhoto() {
        return gymPhoto;
    }

    public void setGymPhoto(ArrayList<String> gymPhoto) {
        this.gymPhoto = gymPhoto;
    }

    public String getGymDescription() {
        return gymDescription;
    }

    public void setGymDescription(String gymDescription) {
        this.gymDescription = gymDescription;
    }

    public String getStartWorkTime() {
        return startWorkTime;
    }

    public void setStartWorkTime(String startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public String getEndWorkTime() {
        return endWorkTime;
    }

    public void setEndWorkTime(String endWorkTime) {
        this.endWorkTime = endWorkTime;
    }

    public ArrayList<String> getClients() {
        return clientIds;
    }

    public void setClients(ArrayList<String> clients) {
        this.clientIds = clients;
    }

    public String getGymLogin() {
        return gymLogin;
    }

    public void setGymLogin(String gymLogin) {
        this.gymLogin = gymLogin;
    }

    public String getGymPassword() {
        return gymPassword;
    }

    public void setGymPassword(String gymPassword) {
        this.gymPassword = gymPassword;
    }
}
