package com.xkc.learn.domain;

import java.util.*;

public class Programmer  {
    private Set<String> users;
    private Map<String, String> words;
    private List<String> cars;
    private Integer[] ints;
    private Properties properties;

    public Programmer() {
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public Map<String, String> getWords() {
        return words;
    }

    public void setWords(Map<String, String> words) {
        this.words = words;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public Integer[] getInts() {
        return ints;
    }

    public void setInts(Integer[] ints) {
        this.ints = ints;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "users=" + users +
                ", words=" + words +
                ", cars=" + cars +
                ", ints=" + Arrays.toString(ints) +
                ", properties=" + properties +
                '}';
    }
}
