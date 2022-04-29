package edu.sjsu.assasins.hotelbooking.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Reservation {
    @Id
    private Long id;

    public int getHotelRoomId() {
        return hotelRoomId;
    }

    public void setHotelRoomId(int hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private int hotelRoomId;
    private float price;
    private Date checkInDate;
    private Date checkOutDate;
    private String amenities;

    public Reservation(long id, int hotelRoomId, float price, Date checkInDate, Date checkOutDate, String amenities) {
        this.id = id;
        this.hotelRoomId = hotelRoomId;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.amenities = amenities;
    }

    public Reservation() {

    }

}