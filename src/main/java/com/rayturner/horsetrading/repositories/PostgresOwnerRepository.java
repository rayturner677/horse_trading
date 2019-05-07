package com.rayturner.horsetrading.repositories;

import com.rayturner.horsetrading.forms.OwnerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.stereotype.Repository
public class PostgresOwnerRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresOwnerRepository(JdbcTemplate jdbcTemplate){
        jdbc = jdbcTemplate;
    }

    public void save(OwnerForm owner) {
        jdbc.update("INSERT INTO users (username, password, email, location) VALUES(?,?,?,?)", owner.username, "{noop}" + owner.password, owner.email , owner.location);
        jdbc.update("INSERT INTO user_roles (username) VALUES(?)", owner.username);
    }
}
