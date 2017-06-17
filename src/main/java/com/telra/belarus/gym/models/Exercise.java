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
    private ArrayList<String> photo = new ArrayList<>();
    private String video;

    public Exercise() {
    }

    public Exercise(String exerciseId, String categoryName, String exerciseName, String title,
                    String description, ArrayList<String> photo, String video) {

        this.exerciseId = exerciseId;
        this.categoryName = categoryName;
        this.exerciseName = exerciseName;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.video = video;
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

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }
}
