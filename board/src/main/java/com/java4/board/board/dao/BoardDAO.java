package com.java4.board.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.java4.board.board.domain.Board;


@Repository
public class BoardDAO {
   
   @Autowired
   private JdbcTemplate jdbcTemplate;

   private RowMapper<Board> mapper = new RowMapper<Board>() {
      @Override
      public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
         // TODO Auto-generated method stub
         return new Board(
               rs.getInt("id"),
               rs.getString("title"),
               rs.getString("content"),
               rs.getInt("views"), 0, 0,
               rs.getTimestamp("created_at"),
               rs.getInt("is_withdrew") == 1,
               rs.getInt("user_id"),
               rs.getString("userName"));
      }
   };

   public void add(Board board) {
      jdbcTemplate.update("insert into boards (\"title\", \"content\", \"is_withdrew\",\"user_id\") values (?, ?, ?,?)",
            board.getTitle(), board.getContent(),board.isWithdrew() ? 1 : 0, board.getUserId());
   }


   public List<Board> getAll(int page, int size) {
	   int offset = (page - 1) * size;
	      return jdbcTemplate.query(
	            "SELECT boards.*, users.\"name\" as \"userName\" FROM boards JOIN users ON boards.\"user_id\" = users.\"id\" ORDER BY boards.\"id\" OFFSET ? ROWS FETCH FIRST ? ROWS ONLY",
	            mapper, offset, size);
	   }
   
   public int getTotalItemCount() {
       return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM boards", Integer.class);
   }
   
   
   
   
   
   public Board getBoardById(int boardId) {
	    return jdbcTemplate.queryForObject(
	        "SELECT boards.*, users.\"name\" as \"userName\" FROM boards JOIN users ON boards.\"user_id\" = users.\"id\" WHERE boards.id = ?",
	        mapper, boardId);
	}

	public void editBoard(Board board) {
	    jdbcTemplate.update(
	        "UPDATE boards SET \"title\" = ?, \"content\" = ? WHERE id = ?",
	        board.getTitle(), board.getContent(), board.getId());
	}

	public void deleteBoard(int boardId) {
	    jdbcTemplate.update("DELETE FROM boards WHERE id = ?", boardId);
	}
   
}