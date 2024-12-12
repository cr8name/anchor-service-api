package com.anchor.anchor_service.karldm.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name="utilities")
public class Utilities  implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilities_id")
    private int utilities_id;
    @Column(name = "customer_id")
    private int customer_id;
    @Column(name = "billing_date")
    private LocalDate billing_date;
    @Transient
    private double total_amount;
    @Transient
    private double electric_bill;
    @Transient
    private double water_bill;
    @Column(name = "electric_rate")
    private double electric_rate;
    @Column(name = "water_rate")
    private double  water_rate;
    @Column(name = "rent_rate")
    private double rent_rate;
    @Column(name = "eprev_read")
    private double eprev_read;
    @Column(name = "ecurr_read")
    private double ecurr_read;
    @Column(name = "wprev_read")
    private double wprev_read;
    @Column(name = "wcurr_read")
    private double wcurr_read;


    public Utilities() {
    }

    public int getUtilities_id() {
        return utilities_id;
    }

    public void setUtilities_id(int utilities_id) {
        this.utilities_id = utilities_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDate getBilling_date() {
        return billing_date;
    }

    public void setBilling_date(LocalDate billing_date) {
        this.billing_date = billing_date;
    }

    public double getTotal_amount() {
        return rent_rate+electric_rate*(ecurr_read-eprev_read)+water_rate*(wcurr_read-wprev_read);
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public double getElectric_bill() {
        return electric_rate*(ecurr_read-eprev_read);
    }

    public void setElectric_bill(double electric_bill) {
        this.electric_bill = electric_bill;
    }

    public double getWater_bill() {
        return water_rate*(wcurr_read-wprev_read) ;
    }

    public void setWater_bill(double water_bill) {
        this.water_bill = water_bill;
    }

    public double getElectric_rate() {
        return electric_rate;
    }

    public void setElectric_rate(double electric_rate) {
        this.electric_rate = electric_rate;
    }

    public double getWater_rate() {
        return water_rate;
    }

    public void setWater_rate(double water_rate) {
        this.water_rate = water_rate;
    }

    public double getRent_rate() {
        return rent_rate;
    }

    public void setRent_rate(double rent_rate) {
        this.rent_rate = rent_rate;
    }

    public double getEprev_read() {
        return eprev_read;
    }

    public void setEprev_read(double eprev_read) {
        this.eprev_read = eprev_read;
    }

    public double getEcurr_read() {
        return ecurr_read;
    }

    public void setEcurr_read(double ecurr_read) {
        this.ecurr_read = ecurr_read;
    }

    public double getWprev_read() {
        return wprev_read;
    }

    public void setWprev_read(double wprev_read) {
        this.wprev_read = wprev_read;
    }

    public double getWcurr_read() {
        return wcurr_read;
    }

    public void setWcurr_read(double wcurr_read) {
        this.wcurr_read = wcurr_read;
    }
}
