package com.rayturner.horsetrading.forms;

public class MessageForm {
    public Integer id;
    public Integer conversation_id;
    public String author_id;
    public String paragraph;

    public MessageForm(Integer id, Integer conversation_id, String author_id, String paragraph) {
        this.id = id;
        this.conversation_id = conversation_id;
        this.author_id = author_id;
        this.paragraph = paragraph;
    }

    public Integer getId() {
        return id;
    }

    public Integer getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Integer conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public boolean is_valid(){
        return conversation_id != null && author_id != null && paragraph != null;
    }
}
