package com.java4.jdbctest.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// POJO
// Plain Old Java Object
// 특정 규약에 종속되지 않는다. << 확실하게 정해진 규칙
// 특정 환경에 종속되지 않는다.
// POJO랑 같이 나오는말 arp?

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode(exclude = { "id" })
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Board {
//	@EqualsAndHashCode.Exclude
	private int id; 
	@NonNull
//	@EqualsAndHashCode.Exclude
	private String user; //final을 해줘도 되지만 충돌난다
	@NonNull
	private String title;
	@NonNull
	private String content;
}
