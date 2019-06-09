package com.AutonomV.Entity;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    private int id;
    private String firstName;
    private String lastName;
    private int authLevel;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Driver() {
    }

    /**
     * @param id
     * @param lastName
     * @param authLevel
     * @param firstName
     */
    public Driver(int id, String firstName, String lastName, int authLevel) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authLevel = authLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(int authLevel) {
        this.authLevel = authLevel;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("id", id).append("firstName", firstName).append("lastName", lastName).append("authLevel", authLevel).append("additionalProperties", additionalProperties).toString();
//    }

}