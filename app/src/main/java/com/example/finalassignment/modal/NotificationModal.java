package com.example.finalassignment.modal;

public class NotificationModal {

    private String title;
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public NotificationModal(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

}
