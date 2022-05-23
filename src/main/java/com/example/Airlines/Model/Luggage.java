package com.example.Airlines.Model;

import javax.persistence.*;

@Entity
@Table(name = "luggage")
public class Luggage {

    @Id
    @Column(name = "pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;

    @Column(name = "flightId")
    private long flightId;

    @Column(name = "luggageType")
    private String luggageType;

    @Column(name = "id")
    private int id;

    @Column(name = "weight")
    private double weight;

    @Column(name ="weightUnit")
    private String weightUnit;

    @Column(name = "pieces")
    private int pieces;

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getLuggageType() {
        return luggageType;
    }

    public void setLuggageType(String luggageType) {
        this.luggageType = luggageType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }
}