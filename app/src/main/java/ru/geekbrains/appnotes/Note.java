package ru.geekbrains.appnotes;

import java.util.Date;

public class Note {
    private String name;
    private String description;
    private String dateCreation;

    public Note(String name, String description, String dateCreation) {
        this.name = name;
        this.description = description;
        this.dateCreation = dateCreation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
