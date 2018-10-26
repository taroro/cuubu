package com.example.artid.cuubu.classes;

public class Room {
    private String roomId;
    private String roomNo;
    private String roomBuilding;
    private int seat;
    private String type;

    public Room() { this.roomId = roomId; }

    public Room(String roomId, String roomNo, String roomBuilding, int seat, String type) {
        this.roomId = roomId;
        this.roomNo = roomNo;
        this.roomBuilding = roomBuilding;
        this.seat = seat;
        this.type = type;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomBuilding() {
        return roomBuilding;
    }

    public void setRoomBuilding(String roomBuilding) {
        this.roomBuilding = roomBuilding;
    }

    public int getSeat() { return seat; }

    public void setSeat(int seat) {  this.seat = seat; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
