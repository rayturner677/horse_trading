package com.rayturner.horsetrading.forms;

public class ConversationForm {
    public Integer id;
    public Integer horse_id;
    public String buyer_id;

    public ConversationForm(Integer id, Integer horse_id, String buyer_id) {
        this.id = id;
        this.horse_id = horse_id;
        this.buyer_id = buyer_id;
    }


    public Integer getId() {
        return id;
    }

    public Integer getHorse_id() {
        return horse_id;
    }

    public void setHorse_id(Integer horse_id) {
        this.horse_id = horse_id;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public boolean is_valid(){
        return horse_id != null && buyer_id != null;
    }


}
