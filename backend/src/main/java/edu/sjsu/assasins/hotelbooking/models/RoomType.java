package edu.sjsu.assasins.hotelbooking.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roomtype")
public class RoomType {
    @Id
    private String roomId;

    private String roomType;
    private long rewardPoints;
    private int price;
}
