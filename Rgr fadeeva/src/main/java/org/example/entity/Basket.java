package org.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "price", nullable = true, precision = 0)
    private Float price;
    @Column(name = "date", nullable = true)
    private String date;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity= Order.class, mappedBy = "basket", cascade = {CascadeType.ALL})
    private Collection<Order> orders;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Customer customer;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Order> getProducts() {
        return orders;
    }

    public void setProducts(Collection<Order> orders) {
        this.orders = orders;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getClient() {
        return customer;
    }

    public void setClient(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + date +
                ", products=" + orders +
                ", client=" + customer +
                '}';
    }
}
