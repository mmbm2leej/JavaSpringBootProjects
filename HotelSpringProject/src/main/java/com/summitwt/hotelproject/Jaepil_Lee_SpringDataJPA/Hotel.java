package com.summitwt.hotelproject.Jaepil_Lee_SpringDataJPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    @GeneratedValue
    private Long hotel_id;
    @Column
    private String name = "PLACEHOLDER";
    @Column
    private String location = "PLACEHOLDER";
    @Column
    @OneToMany(mappedBy="hotel")
    private List<Room> roomList = new ArrayList<>();
    @Column
    private Integer numOfRooms = 0;
    @Column
    private Integer occupiedCnt = 0;
    @Column
    private static final int NOT_FOUND = -1;


    public Hotel() {
    }

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public Integer getOccupiedCnt() {
        return occupiedCnt;
    }

    public void setOccupiedCnt(Integer occupiedCnt) {
        this.occupiedCnt = occupiedCnt;
    }

    public static int getNotFound() {
        return NOT_FOUND;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotel_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", roomList=" + roomList +
                ", numOfRooms=" + numOfRooms +
                ", occupiedCnt=" + occupiedCnt +
                '}';
    }

    /*
    //ONLY ADDS ROOMS IN THE LIST, NOT THE DATABASE
    public void addRoom(String sqlURL,
                        String sqlUser, String sqlPass) {
        System.out.println("Beginning addRoom Procedure");
        Integer roomid = roomList.size();
        String typeDes;
        Character smoke = 'n';
        Double dailyRate = 90.00;
        Random myRand = new Random();
        int typeGenerate = myRand.nextInt(4);
        boolean smokeGenerate = myRand.nextBoolean();

        //placeholder
        roomList.add(roomid, new Room(roomid, "Regular", smoke, dailyRate));

        //replaced by random generation
        if (!roomList.get(roomid).getRandomized()) {
            switch (typeGenerate) {
                case 1:
                    typeDes = "Queen";
                    dailyRate = 75.00;
                    break;
                case 2:
                    typeDes = "King";
                    dailyRate = 95.00;
                    break;
                default:
                    typeDes = "Twin";
                    dailyRate = 60.00;

            }
            smoke = (smokeGenerate) ? 's' : 'n';
            Room curr = new Room(roomid+100, typeDes, smoke, dailyRate);
            curr.setRandomized();
            roomList.set(roomid,curr);


            typeGenerate = myRand.nextInt(4);

        }

        numOfRooms++;
        System.out.println("addRoom Procedure Complete");

    }

    public void addRoom(String typeDes, Character smoke, Double dailyRate, String sqlURL,
                        String sqlUser, String sqlPass) throws  SQLException {
        System.out.println("Beginning addRoom Procedure");
        Integer roomid = roomList.size();

        //placeholder
        roomList.add(roomid, new Room(roomid, "Regular", smoke, dailyRate));

        Room curr = new Room(roomid+100, typeDes, smoke, dailyRate);
        curr.setRandomized();
        roomList.set(roomid,curr);
        try {
            Connection myConn = DriverManager.getConnection(sqlURL,sqlUser,sqlPass);
            Statement st = myConn.createStatement();
            String getHotelIDQuery = "SELECT hotel_id from hotel WHERE hotel_name = '" + name + "';";
            ResultSet hotelidRS = st.executeQuery(getHotelIDQuery);

            String myAddRoomQuery = "INSERT INTO room VALUES(default,'" + smoke + "'," + dailyRate +
                    ",false,NULL,'" + hotelidRS.toString() + "');";
            st.executeUpdate(myAddRoomQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        numOfRooms++;
        System.out.println("addRoom Procedure Complete");

    }

    @Override
    public String toString() {
        return ("\n\nHotel name:'" + name +
                "\nLocation='" + location +
                "\nNumber of Rooms: " + numOfRooms +
                "\nOccupied Count: " + occupiedCnt +
                "\n\nRoom Details: " + roomList + "\n");
    }


    public ArrayList<Room> getRoomlist() {
        return roomList;
    }

    public int getRoomListSize() {
        return roomList.size();
    }

    public boolean isFull() {
        return (numOfRooms == occupiedCnt);
    }

    //only works if there are rooms made
    //otherwise returns false
    public boolean isEmpty() {
        return ((occupiedCnt == 0) && (numOfRooms > 0));
    }

    //-1 for not found, else index in list
    public Integer findReservation(String occupantName) {
        for(int i = 0; i < roomList.size(); ++i) {
            if (roomList.get(i).getRenter() == occupantName) {
                System.out.println("Found reservation for "+ occupantName + ".");
                return i;
            }
        }
        return NOT_FOUND;
    }

    public void addReservation(String occupantName, Character requestSmoking, String requestedBed) {
        //search through list
        for(Room x : roomList) {

            //if there is a matched room available, set the name and occupied
            if ((!x.isOccupied()) &&
                    (x.getSmoking() == requestSmoking) &&
                    (x.getBedType() == requestedBed)) {

                x.setOccupant(occupantName);
                x.setOccupied(true);
                occupiedCnt++;

                System.out.println("Reservation for " + occupantName + " has been made for " +
                        requestSmoking + ", " + requestedBed);

                return;
            }
        }

        //no match
        System.out.println("No matching available rooms have been found.");
    }

    public void cancelReservation(String occupantName) {
        for(Room x : roomList) {
            if (x.getRenter() == occupantName) {
                x.setOccupant("Not Occupied");
                x.setOccupied(false);
                occupiedCnt--;

                System.out.println("Reservation for "+ occupantName + " has been removed from the list.");
                return;
            }
        }

        System.out.println("Reservation for " + occupantName + " could not be found.");
    }

    public void printReservationList() {
        for(Room x : roomList) {
            if (x.isOccupied()) {
                System.out.print("\n\nRoom Number: " + x.getRoomNum() +
                        "\nOccupant Name: " + x.getRenter() +
                        "\nSmoking Room: " + x.getSmoking() +
                        "\nBed Type: " + x.getBedType() +
                        "\nRate: " + String.format("%.2f", x.getRoomRate()) + "\n\n");
            }
        }
    }

    public Double getDailySales() {
        Double total = 0.0;
        for(Room x : roomList) if (x.isOccupied()) total += x.getRoomRate();
        return total;
    }

    public Double occupancyPercentage() {
        return (occupiedCnt*1.0/numOfRooms);
    }

     */

}
