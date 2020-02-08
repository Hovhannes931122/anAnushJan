package com.example.common.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    private Set<User> coachGroups = new HashSet<User>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private double price;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "product",
            joinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Column
    private int count;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "product_image",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private List<Image> images;

    @ManyToMany(fetch = FetchType.LAZY)
    private Category category;

    @Column
    private double rating;

    @OneToMany(cascade=CascadeType.ALL, targetEntity=User.class)
    @JoinColumn(name="products")
    private Set<User> users;


}
