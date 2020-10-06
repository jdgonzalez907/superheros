package com.jdgonzalez907.superhero.models;

import java.io.Serializable;

public class SuperHeroImage implements Serializable {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SuperHeroImage{" +
                "url='" + url + '\'' +
                '}';
    }
}
