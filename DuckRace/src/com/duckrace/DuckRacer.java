package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class DuckRacer implements Serializable {
    //properties, fields, instance variables
    private final int id;
    private String name;
    private final Collection<Reward> rewards = new ArrayList<>();

    //constructors
    public DuckRacer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void win(Reward reward){
        rewards.add(reward);
    }

    //accessor methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Derived property, don't need to keep track of the wins as you can see the amount through the rewards list
    public int getWins(){
        return rewards.size();
    }

    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
    }

    @Override
    public String toString() {
        return String.format("%s: id=%s, name=%s, wins=%s, rewards=%s",getClass().getSimpleName(),getId(),getName(),getWins(),getRewards());
    }
}