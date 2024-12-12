package com.anchor.anchor_service.karldm.Entity;


import jakarta.persistence.*;


import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="billing")
public class Billing  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="billing_id")
    private int billing_id;
    @Column(name="utilities_id")
    private int utilities_id;
    @Column(name="customer_id")
    private int customer_id;
    @Column(name="total_amount")
    private double total_amount;
    @Column(name="rent_amount")
    private double rent_amount;
    @Column(name="electric_bill")
    private double electric_bill;
    @Column(name="water_bill")
    private double water_bill;
    @Column(name="billing_cycle_date")
    private LocalDate billing_cycle_date;

    public Billing() {
    }

    public Billing(int billing_id, int utilities_id, int customer_id, double total_amount, double rent_amount,
                   double electric_bill, double water_bill, LocalDate billing_cycle_date) {
        this.billing_id = billing_id;
        this.utilities_id = utilities_id;
        this.customer_id = customer_id;
        this.total_amount = total_amount;
        this.rent_amount = rent_amount;
        this.electric_bill = electric_bill;
        this.water_bill = water_bill;
        this.billing_cycle_date = billing_cycle_date;
    }

    public int getBilling_id() {
        return billing_id;
    }

    public int getUtilities_id() {
        return utilities_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public double getRent_amount() {
        return rent_amount;
    }

    public void setRent_amount(double rent_amount) {
        this.rent_amount = rent_amount;
    }

    public double getElectric_bill() {
        return electric_bill;
    }

    public void setElectric_bill(double electric_bill) {
        this.electric_bill = electric_bill;
    }

    public double getWater_bill() {
        return water_bill;
    }

    public void setWater_bill(double water_bill) {
        this.water_bill = water_bill;
    }

    public LocalDate getBilling_cycle_date() {
        return billing_cycle_date;
    }

    public void setBilling_cycle_date(LocalDate billing_cycle_date) {
        this.billing_cycle_date = billing_cycle_date;
    }


}
