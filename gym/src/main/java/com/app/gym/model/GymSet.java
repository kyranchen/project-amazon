package com.app.gym.model;

public class GymSet {

    private Integer id;

    private String name;

    private Double weight;

    private Integer sets;

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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "GymSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", sets=" + sets +
                '}';
    }
}
