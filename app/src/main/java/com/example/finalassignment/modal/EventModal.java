package com.example.finalassignment.modal;

public class EventModal {

    private String _id;
    private String event_name;
    private String event_desc;
    private String image;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_desc() {
        return event_desc;
    }

    public void setEvent_desc(String event_desc) {
        this.event_desc = event_desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public EventModal(String _id, String event_name, String event_desc, String image) {
        this._id = _id;
        this.event_name = event_name;
        this.event_desc = event_desc;
        this.image = image;
    }


}
