package edu.sjsu.assasins.hotelbooking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {
     @Id
     private int hotelid;
     private String name;
     private String location;
     private String image;

     public String getImage() {
          return image;
     }

     public void setImage(String image) {
          this.image = image;
     }

     public int getHotelid() {
          return hotelid;
     }

     public String getName() {
          return name;
     }

     public String getLocation() {
          return location;
     }

     public void setHotelid(int hotelid) {
          this.hotelid = hotelid;
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setLocation(String location) {
          this.location = location;
     }

     public Hotel(int hotelid, String name, String location, String image) {
          this.hotelid = hotelid;
          this.name = name;
          this.location = location;
          this.image = image;
     }

     public Hotel() {
     }
}
