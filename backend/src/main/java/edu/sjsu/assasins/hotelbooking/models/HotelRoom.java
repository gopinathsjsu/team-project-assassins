package edu.sjsu.assasins.hotelbooking.models;

import javax.persistence.*;

@Entity
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int hotelid;
    private int roomid;
    private String typeofroom;
    private int numberofrooms;
    private int availability;

    public HotelRoom() {
    }

    public HotelRoom(int id, int hotelid, int roomid, String typeofroom, int numberofrooms, int availability) {
        this.id = id;
        this.hotelid = hotelid;
        this.roomid = roomid;
        this.typeofroom = typeofroom;
        this.numberofrooms = numberofrooms;
        this.availability = availability;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public void setTypeofroom(String typeofroom) {
        this.typeofroom = typeofroom;
    }

    public void setNumberofrooms(int numberofrooms) {
        this.numberofrooms = numberofrooms;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public int getHotelid() {
        return hotelid;
    }

    public int getRoomid() {
        return roomid;
    }

    public String getTypeofroom() {
        return typeofroom;
    }

    public int getNumberofrooms() {
        return numberofrooms;
    }

    public int getAvailability() {
        return availability;
    }
}
