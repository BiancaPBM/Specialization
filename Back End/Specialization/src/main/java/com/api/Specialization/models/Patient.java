package com.api.Specialization.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    @Id
    private String _id;
    @Field("age")
    private int age;
    @Field("firstname")
    private String firstName;
    @Field("lastname")
    private String lastName;
    @Field("speciality")
    private List<String> specialityPreferences;
    @Field("contact")
    private Contact contact;
    @Field("allergies")
    private List<String> allergies;
    @Field("symptoms")
    private List<String> symptoms;

    public Patient(String _id, int age, String firstName, String lastName, List<String> specialityPreferences, Contact contact) {
        this._id = _id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialityPreferences = specialityPreferences;
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<String> getSpecialityPreferences() {
        return specialityPreferences;
    }

    public void setSpecialityPreferences(List<String> specialityPreferences) {
        this.specialityPreferences = specialityPreferences;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
