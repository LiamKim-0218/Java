package com.java4.board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4.board.board.dao.BoardDAO;
import com.java4.board.board.domain.Board;

@Service
public class BoardService {
	@Autowired
	BoardDAO boardDao;
	
	public void add(Board board) {
		boardDao.add(board);
	}
	
	public List<Board> getAll(int page, int size){
		return boardDao.getAll(page, size);
	}
	
	public int getTotalItemCount() {
        return boardDao.getTotalItemCount();
    }
	
	
	
	public Board getBoardById(int boardId) {
	    return boardDao.getBoardById(boardId);
	}

	public void editBoard(Board board) {
	    boardDao.editBoard(board);
	}

	public void deleteBoard(int boardId) {
	    boardDao.deleteBoard(boardId);
	}
}
