package com.app.gym.model;

import java.util.Date;

public class GymSet {

    private Integer id;

    private String name;

    private Double weight;

    private Integer sets;

    private Date date;

    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
                ", date=" + date +
                ", group='" + group + '\'' +
                '}';
    }
}
