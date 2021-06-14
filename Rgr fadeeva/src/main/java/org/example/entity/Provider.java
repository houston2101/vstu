package org.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоматический генератор айди
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "lastname", nullable = true, length = 45)
    private String lastname;
    @Column(name = "speciality", nullable = true, length = 45)
    private String speciality;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity= Order.class, mappedBy = "seller", cascade = {CascadeType.ALL})
    private Collection<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", speciality='" + speciality + '\'' +
                ", products=" + orders +
                '}';
    }
}
