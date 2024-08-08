package com.emass.advert.repository;

import jakarta.persistence.*;
import com.emass.user.repository.UserEntity;
import lombok.Data;

@Data
@Entity
@Table(name = "advert")
public class AdvertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "rooms")
    private int rooms;

    @Column(name = "bathrooms")
    private int bathrooms;

    @Column(name = "area")
    private int area;

    @Column(name = "year_built")
    private int yearBuilt;

    @Column(name = "floors")
    private int floors;

    @Column(name = "floor_number")
    private int floorNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "heating_type")
    private String heatingType;

    @Column(name = "air_conditioning")
    private boolean airConditioning;

    @Column(name = "balcony")
    private boolean balcony;

    @Column(name = "parking")
    private boolean parking;

    @Column(name = "furnished")
    private boolean furnished;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "rental_price")
    private double rentalPrice;

    @Column(name = "emlak_turu")
    private String emlakTuru;

    @Column(name = "kategori")
    private String kategori;

    @Column(name = "ilanTuru")
    private String ilanTuru;
}
