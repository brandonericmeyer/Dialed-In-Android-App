package com.regis.helloworld.dialedin.domain;

import java.util.ArrayList;
import java.util.List;

public class Workout implements java.io.Serializable {
    private String name;
    private List<String> exercises = new ArrayList<>();

    public Workout(String name, List<String> exercises){
        this.name = name;
        this.exercises = exercises;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<String> getExercises(){
        return exercises;
    }
}
