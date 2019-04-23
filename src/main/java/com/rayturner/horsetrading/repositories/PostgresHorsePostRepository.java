package com.rayturner.horsetrading.repositories;

import com.rayturner.horsetrading.forms.PostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresHorsePostRepository implements com.rayturner.horsetrading.repositories.Repository<PostForm>{
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresHorsePostRepository (JdbcTemplate jdbcTemplate){
        jdbc = jdbcTemplate;
    }


    public void save(PostForm owner) {
        jdbc.update("INSERT INTO users (username, password, email, location) VALUES(?,?,?)", owner.username,
                owner.password, owner.location , owner.email);
    }

//    private PostForm mapToRow(ResultSet row, int rowNum) throws SQLException {
//        return new EmployerForm(
//                row.getInt("id"),
//                row.getString("name"),
//                row.getString("address"),
//                row.getString("description"),
//                row.getString("benefits"),
//                row.getString("email")
//        );
//
//    }

}
