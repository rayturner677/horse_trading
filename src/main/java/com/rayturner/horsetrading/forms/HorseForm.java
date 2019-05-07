package com.rayturner.horsetrading.forms;

public class HorseForm {
    public Integer id;
    public String name;
    public String location;
    public String description;
    public String owner;
    public String horse_pic_url;

    public HorseForm(Integer id, String name, String location, String description, String owner, String horse_pic_url) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.owner = owner;
        this.horse_pic_url = horse_pic_url;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHorse_pic_url() {
        return horse_pic_url;
    }

    public void setHorse_pic_url(String horse_pic_url) {
        this.horse_pic_url = horse_pic_url;
    }

    public boolean is_valid(){
        return  name != null && location != null  && description != null && horse_pic_url != null && owner != null;
    }
}
