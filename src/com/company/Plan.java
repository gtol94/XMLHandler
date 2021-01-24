package com.company;

public class Plan {
    private String name, job;
    public Plan(String name, String job){
        this.name = name;
        this.job = job;
    }
    public String getName(){
        return name;
    }
    public String getJob(){
        return job;
    }
}
