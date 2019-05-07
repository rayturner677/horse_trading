package com.rayturner.horsetrading.repositories;

import com.rayturner.horsetrading.forms.ConversationForm;
import com.rayturner.horsetrading.forms.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostgresMessageRepository {
    public JdbcTemplate jdbc;

    @Autowired
    public PostgresMessageRepository(JdbcTemplate jdbcTemplate){
        jdbc = jdbcTemplate;
    }

    public void save(MessageForm message){
        jdbc.update("INSERT INTO messages(conversation_id, author_id, paragraph) VALUES(?,?,?)", message.conversation_id, message.author_id, message.paragraph);
    }

    public List<MessageForm> findAll(int conversationId){
        return jdbc.query("SELECT id, conversation_id, author_id, paragraph FROM messages WHERE conversation_id = ?", this::mapToRow, conversationId);
    }

    private MessageForm mapToRow(ResultSet row, int rowNum) throws SQLException {
        return new MessageForm(
                row.getInt("id"),
                row.getInt("conversation_id"),
                row.getString("author_id"),
                row.getString("paragraph")
        );
    }
}
