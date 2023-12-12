package com.aula.Aula.data.vo;


import jakarta.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;



public class PersonVo implements Serializable {

    private static final long serialVersionUID = 1L;


    private long id;

    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonVo(long id, String firstName, String lastName, String address, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public PersonVo() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVo person)) return false;
        return getId() == person.getId() &&
                Objects.equals(getFirstName(),
                        person.getFirstName()) &&
                Objects.equals(getLastName(),
                        person.getLastName()) &&
                Objects.equals(getAddress(),
                        person.getAddress()) &&
                Objects.equals(getGender(),
                        person.getGender());
    }


    public int hashCode() {
        return Objects.hash(getId(),
                getFirstName(),
                getLastName(),
                getAddress(),
                getGender());
    }
}
