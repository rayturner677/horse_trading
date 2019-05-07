package com.rayturner.horsetrading.repositories;

import com.rayturner.horsetrading.forms.ConversationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.module.Configuration;

@Repository
public class ConversationRepository {
    public JdbcTemplate jdbc;

    @Autowired
    public ConversationRepository(JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
    }

    public int save(ConversationForm conversation){
        return (Integer ) jdbc.queryForList("INSERT INTO conversations(horse_id, buyer_id) VALUES(?,?) RETURNING id",
                conversation.horse_id,
                conversation.buyer_id).get(0).get("id");
    }
}
