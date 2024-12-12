
package com.anchor.anchor_service.karldm.Entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "customer_id")
   private int customer_id;
   @Column(name = "first_name")
   private String first_name;
   @Column(name = "last_name")
   private String last_name;
   @Column(name = "address")
   private String address;
   @Column(name ="current_status")
   private String current_status;
   @Column(name="date_created")
   private LocalDate date_created;
   @Column(name="last_edited")
   private LocalDateTime last_edited;



    public Customer() {
    }

    public Customer(int customer_id, String first_name, String last_name,
                    String address, String current_status, LocalDate date_created, LocalDateTime last_edited) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.current_status = current_status;
        this.date_created = date_created;
        this.last_edited = last_edited;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public LocalDateTime getLast_edited() {
        return last_edited;
    }

    public void setLast_edited(LocalDateTime last_edited) {
        this.last_edited = last_edited;
    }
}
