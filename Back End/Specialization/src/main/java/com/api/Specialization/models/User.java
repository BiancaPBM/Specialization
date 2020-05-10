package com.api.Specialization.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.*;

@Document(collection = "users")
public class User {
    @Id
    private String _id;
    @Field("name")
    private String name;
    @Field("age")
    private int age;
    @Field("address")
    private String address;
    @Field("email")
    private String email;
    @Field("telephone")
    private String telephone;
    @Field("specialityPreferences")
    private List<String> specialityPreferences;

    public User(String _id, String name, int age, String address, String email, String telephone, List<String> specialityPreferences) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.specialityPreferences = specialityPreferences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<String> getSpecialityPreferences() {
        return specialityPreferences;
    }

    public void setSpecialityPreferences(List<String> specialityPreferences) {
        this.specialityPreferences = specialityPreferences;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

}