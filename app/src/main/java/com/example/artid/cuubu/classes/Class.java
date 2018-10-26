package com.example.artid.cuubu.classes;

public class Class {
    private String startTime;
    private String endTime;
    private String dayOfWeek;
    private String subjectId;
    private String subjectTitle;
    private String roomNo;
    private String roomBuilding;
    private int semester;
    private String year;

    public Class() { }

    public Class(String startTime, String endTime, String dayOfWeek, String subjectId,
                 String subjectTitle, String roomNo, String roomBuilding,
                 int semester, String year) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
        this.subjectId = subjectId;
        this.subjectTitle = subjectTitle;
        this.roomNo = roomNo;
        this.roomBuilding = roomBuilding;
        this.semester = semester;
        this.year = year;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getSubjectId() { return subjectId; }

    public void setSubjectId(String subjectId) { this.subjectId = subjectId; }

    public String getSubjectTitle() { return subjectTitle; }

    public void setSubjectTitle(String subjectTitle) { this.subjectTitle = subjectTitle; }

    public String getRoomNo() { return roomNo; }

    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public String getRoomBuilding() { return roomBuilding; }

    public void setRoomBuilding(String roomBuilding) { this.roomBuilding = roomBuilding; }

    public int getSemester() { return semester; }

    public void setSemester(int semester) { this.semester = semester; }

    public String getYear() { return year; }

    public void setYear(String year) { this.year = year; }
}
