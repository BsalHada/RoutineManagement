package com.example.finalassignment.modal;

public class ScheduleModal {

    private String class_name;
    private String course_name;
    private String course_code;
    private String time;
    private String room_no;
    private String batch;
    private String techer_name;
    private String day;

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getTecher_name() {
        return techer_name;
    }

    public void setTecher_name(String techer_name) {
        this.techer_name = techer_name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ScheduleModal(String class_name, String course_name, String course_code, String time, String room_no, String batch, String techer_name, String day) {
        this.class_name = class_name;
        this.course_name = course_name;
        this.course_code = course_code;
        this.time = time;
        this.room_no = room_no;
        this.batch = batch;
        this.techer_name = techer_name;
        this.day = day;
    }
}
