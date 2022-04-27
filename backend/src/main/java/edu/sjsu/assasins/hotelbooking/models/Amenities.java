package edu.sjsu.assasins.hotelbooking.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "amenities")
public class Amenities {

    @Id
    private Long amenityId;
    private String amenityName;
    private int amenityPrice;

    public Long getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(Long amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public int getAmenityPrice() {
        return amenityPrice;
    }

    public void setAmenityPrice(int amenityPrice) {
        this.amenityPrice = amenityPrice;
    }
}
