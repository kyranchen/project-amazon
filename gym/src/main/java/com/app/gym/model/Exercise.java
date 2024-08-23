package com.app.gym.model;

public class Exercise {

    private String name;

    private String bodyPart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "name='" + name + '\'' +
                ", bodyPart='" + bodyPart + '\'' +
                '}';
    }
}
