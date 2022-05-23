package com.example.Airlines.Model;

import javax.persistence.*;

@Entity
@Table(name ="Flights")
public class Flight {


    @Id
    @Column(name = "pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;

    @Column(name = "flightId")
    private long flightId;

    @Column(name = "flightNumber")
    private long flightNumber;

    @Column(name = "departureAirportIATACode")
    private String departureAirportIATACode;

    @Column(name = "arrivalAirportIATACode")
    private String arrivalAirportIATACode;

    @Column(name = "departureDate")
    private String departureDate;


    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(String departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}
