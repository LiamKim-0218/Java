package com.java4.board.board.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Board {
	private int id;
	@NonNull
	private String title;
	@NonNull
	private String content;
	private int views;
	private int likes;
	private int hates;
	private Timestamp createAt;
	private boolean isWithdrew;
	@NonNull
	private int userId;
}
