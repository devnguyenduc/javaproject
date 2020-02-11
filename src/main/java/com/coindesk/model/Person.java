package com.coindesk.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Validated
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Size(min=1, max=20)
    @NotNull
    private String firstName;
    @Size(min=1, max=40)
    @NotNull
    private String lastName;

    protected Person() {
        this.firstName = " ";
        this.lastName = " ";
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Person temp){
        this.id = temp.id;
        this.firstName = temp.firstName;
        this.lastName = temp.lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public void set(Person _person){
        if(this.id != _person.id){
            return ;
        }
        this.firstName = _person.firstName;
        this.lastName = _person.lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}