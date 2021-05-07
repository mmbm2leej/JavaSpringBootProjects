package com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA;


import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @ManyToOne
    @JoinColumn(name="hotel_id", nullable=false)
    private Hotel hotel;

    @Id
    @GeneratedValue
    @Column
    private Integer roomNum = -1;
    @Column
    private String bedType;
    @Column
    private Character smokingRoom = 'n';
    @Column
    private Double rate;
    @Column
    private boolean randomized = false;
    @Column
    private boolean occupied = false;
    @Column
    private String renter = "Not Occupied";

    public Room() {
        //System.out.println("Room Constructor called.");
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public Character getSmokingRoom() {
        return smokingRoom;
    }

    public void setSmokingRoom(Character smokingRoom) {
        this.smokingRoom = smokingRoom;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isRandomized() {
        return randomized;
    }

    public void setRandomized(boolean randomized) {
        this.randomized = randomized;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getRenter() {
        return renter;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }

    @Override
    public String toString() {
        return "Room{" +
                "hotel=" + hotel +
                ", roomNum=" + roomNum +
                ", bedType='" + bedType + '\'' +
                ", smokingRoom=" + smokingRoom +
                ", rate=" + rate +
                ", randomized=" + randomized +
                ", occupied=" + occupied +
                ", renter='" + renter + '\'' +
                '}';
    }

    /*
    public Room(Integer roomNumber, String bedType, Character smokingRoom, Double rate) {
        this.roomNum = roomNumber;
        this.bedType = bedType;
        this.smokingRoom = smokingRoom;
        this.rate = rate;
        //System.out.println("Room Constructor called.");
    }

    @Override
    public String toString() {
        return "\n\nRoom Number: " + roomNum +
                "\nOccupant Name: " + renter +
                "\nRoom Type: " + bedType +
                "\nSmoking Room: " + smokingRoom +
                "\nRate=" + String.format("%.2f", rate) + "\n";
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getBedType() {
        return bedType;
    }

    public Character getSmoking() {
        return smokingRoom;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupant(String renterName) { this.renter = renterName; }

    public String getRenter() {
        return renter;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getRoomRate() {
        return rate;
    }

    public boolean getRandomized() {
        return randomized;
    }

    public void setRandomized() {
        randomized = true;
    }


     */
}
