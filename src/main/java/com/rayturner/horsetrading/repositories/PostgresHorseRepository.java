package com.rayturner.horsetrading.repositories;

import com.rayturner.horsetrading.forms.HorseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresHorseRepository{
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresHorseRepository(JdbcTemplate jdbcTemplate){
        jdbc = jdbcTemplate;
    }


    public void save(HorseForm horse) {
        jdbc.update("INSERT INTO horses (name, location, description, owner, horse_pic_url) VALUES(?,?,?,?,?)", horse.name,
                horse.location ,horse.description, horse.owner , horse.horse_pic_url);
    }

    public List<HorseForm> findAll(){
        return jdbc.query("SELECT id, name, location, description, owner, horse_pic_url FROM horses", this::mapToRow);
    }

    public Optional<HorseForm> findById(Integer id){
        return Optional.ofNullable(jdbc.queryForObject("SELECT id, name, location, description, owner, horse_pic_url FROM horses WHERE id=?", this::mapToRow, id));
    }

   private HorseForm mapToRow(ResultSet row, int rowNum) throws SQLException {
        return new HorseForm(
                row.getInt("id"),
                row.getString("name"),
                row.getString("location"),
                row.getString("description"),
                row.getString("owner"),
                row.getString("horse_pic_url")
        );

    }

}
