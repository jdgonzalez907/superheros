package com.jdgonzalez907.superhero.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SuperHeroBiography implements Serializable {
    @SerializedName("full-name")
    private String fullName;
    private String publisher;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "SuperHeroBiography{" +
                "fullName='" + fullName + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
