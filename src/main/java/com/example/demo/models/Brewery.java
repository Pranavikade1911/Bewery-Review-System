package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brewery {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String address;
     private String phone;
     private String website_url;
     private String state;

     public Brewery() {
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public String getPhone() {
          return phone;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public String getWebsite_url() {
          return website_url;
     }

     public void setWebsite_url(String website_url) {
          this.website_url = website_url;
     }

     public String getState() {
          return state;
     }

     public void setState(String state) {
          this.state = state;
     }

     public String getCity() {
          return city;
     }

     public void setCity(String city) {
          this.city = city;
     }

     private String city;
     private int currentRating;

     public int getCurrentRating() {
          return currentRating;
     }

     public void setCurrentRating(int currentRating) {
          this.currentRating = currentRating;
     }


     // Add other necessary fields

     // Constructors, getters, and setters

     public Brewery(String name, String address, String phone, String website_url, String state, String city) {
          this.name = name;
          this.address = address;
          this.phone = phone;
          this.website_url = website_url;
          this.state = state;
          this.city = city;
     }

     // Add getters and setters for other fields

     // toString method for easy debugging and logging
     @Override
     public String toString() {
          return "Brewery{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    ", website_url='" + website_url + '\'' +
                    ", state='" + state + '\'' +
                    ", city='" + city + '\'' +
                    '}';
     }
}
