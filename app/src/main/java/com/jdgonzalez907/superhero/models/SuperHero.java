package com.jdgonzalez907.superhero.models;

import java.io.Serializable;

public class SuperHero implements Serializable {
    private Integer id;
    private String name;
    private SuperHeroPowerStatidistics powerstats;
    private SuperHeroBiography biography;
    private SuperHeroImage image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuperHeroPowerStatidistics getPowerstats() {
        return powerstats;
    }

    public void setPowerstats(SuperHeroPowerStatidistics powerstats) {
        this.powerstats = powerstats;
    }

    public SuperHeroBiography getBiography() {
        return biography;
    }

    public void setBiography(SuperHeroBiography biography) {
        this.biography = biography;
    }

    public SuperHeroImage getImage() {
        return image;
    }

    public void setImage(SuperHeroImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", powerstats=" + powerstats.toString() +
                ", biography=" + biography.toString() +
                ", image=" + image.toString() +
                '}';
    }
}
