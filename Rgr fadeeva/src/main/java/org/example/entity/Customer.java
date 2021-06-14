package org.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоматический генератор айди
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "surname", nullable = true, length = 45)
    private String surname;
    @Column(name = "telephone", nullable = true, length = 45)
    private String telephone;
    @Column(name = "passport", nullable = true, length = 45)
    private String passport;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany( mappedBy = "customer", cascade = {CascadeType.ALL})  private Collection<Basket> baskets;
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


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Collection<Basket> getReservations() {
        return baskets;
    }

    public void setReservations(Collection<Basket> baskets) {
        this.baskets = baskets;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
