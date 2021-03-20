package ru.geekbrains.appnotes;

import java.util.Date;

public class Note {
    private String name;
    private String description;
    private Date dateCreation;

    public Note(String name, String description) {
        this.name = name;
        this.description = description;
        this.dateCreation = new Date();
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
