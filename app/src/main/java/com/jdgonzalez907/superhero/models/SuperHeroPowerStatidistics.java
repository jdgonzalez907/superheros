package com.jdgonzalez907.superhero.models;

import java.io.Serializable;

public class SuperHeroPowerStatidistics implements Serializable {
    private String strength;
    private String speed;
    private String durability;
    private String power;
    private String combat;

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }

    @Override
    public String toString() {
        return "SuperHeroPowerStatidistics{" +
                "strength='" + strength + '\'' +
                ", speed='" + speed + '\'' +
                ", durability='" + durability + '\'' +
                ", power='" + power + '\'' +
                ", combat='" + combat + '\'' +
                '}';
    }
}
