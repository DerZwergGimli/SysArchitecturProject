package com.AutonomV.Entity.Passengers;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    private String id;
    private String firstName;
    private String lastName;
    private String authLevel;

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
    public Driver(String id, String firstName, String lastName, String authLevel) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authLevel = authLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(String authLevel) {
        this.authLevel = authLevel;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", authLevel=" + authLevel +
                '}';
    }

    //    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("id", id).append("firstName", firstName).append("lastName", lastName).append("authLevel", authLevel).append("additionalProperties", additionalProperties).toString();
//    }

}