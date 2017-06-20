package com.telra.belarus.gym.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * Created by Boris on 12.06.2017.
 */
@Document(collection = "exercise")
public class Exercise {
    private static final long serialVersionUID = -123456781L;

    @Id
    private String exerciseId;
    private String categoryName;
    private String exerciseName;
    private String title;
    private String description;
    private String reps;
    private String sets;
    private String duration;
    private ArrayList<String> photo = new ArrayList<>();
    private String video;

    public Exercise() {
    }

    public Exercise(String exerciseId, String categoryName, String exerciseName, String title, String description, String reps, String sets, String duration, ArrayList<String> photo, String video) {
        this.exerciseId = exerciseId;
        this.categoryName = categoryName;
        this.exerciseName = exerciseName;
        this.title = title;
        this.description = description;
        this.reps = reps;
        this.sets = sets;
        this.duration = duration;
        this.photo = photo;
        this.video = video;
    }

    public String getExerciseId() {

        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<String> getPhoto() {
        return photo;
    }

    public void setPhoto(ArrayList<String> photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
