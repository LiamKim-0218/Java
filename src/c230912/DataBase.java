package c230912;

public class DataBase {
/*
    DataBase
    자료를 저장하는 곳
    데이터를 저장하는 곳
    저장한 자료를 찾는 곳

##   종류
   -noSQL
   - 크게 정해진 규격이 없다.
   - MongoDB, Redis
      - MongoDB - 타입에 대해서 연연하지 않음. 로고 관련할때 많이 씀. /기업에서 많이씀
      - Redis   - 특정한 자료들을 빠르게 불러와야 할때 저장함.
      
   -SQL, RDBMS
   - 쓰려면 규칙에 맞춰야 한다.
   - 제대로 쓰려면 좀 어렵다.
   - Oracle, mySQL

##   SQL
   - Language << DB랑 대화한다.
   - Stuctured Query Lagnguage 구조적인 언어

##   명령어   
   - 구조 생성 create
   
create table test (
 
id number(10,0), PRIMARY KEY null이 들어갈 수 없고 찾을때 id number로 찾으면 빠르다 .
name varchar2(10),
score number(10,5)
address varchar2(20)
);

create table test2 (
 
id number(10,0), CONSTRAINT pk_id PRIMARY KEY,
name varchar2(10) CONSTRAINT  < 넣어도 상관없음 안넣어도됨 NOT NULL,
score number(10,5) DEFAULT 0,
address varchar2(20)
);

create table test3(
id number(10,0),
name varchar2(10),
score number(10,5),
address varchar2(20),
created_at timestamp default to_date(sysdate,'yyyy/mm/dd hh:mi:ss')
);


to_date 
to_char 시간을 문자로 불러온다 
sysdate
created_at timestamp default to_date(sysdate,'yyyy/mm/dd hh:mi:ss'));



sysdate 받아서 데이터를 또 바꿔줘야 초 단위 까지 출력가능
//시간 서버의 기본시간 설정

   -CONSTRAINT : 제약 조건
   
   - 구조 삭제 drop
   - 구조 수정(테이블) alter
   - 테이블 명 수정 rename
   
##   데이터 조작어(명령어), DML   
   - 삽입 insert      
      -insert into 테이블 (컬럼명, 컬럼명, ...) values (값,값, ...);
       insert into test (id) values (1);
       insert into test2 values (1, '김남균', '80','분당');
   - 수정 update
      -update 테이블명 set 컬럼명 = 값, 컬럼명 = 값, ... where 조건
       update test set name= '권원준',score=90 where id = 1;
   - 삭제 delete
      - delete from 테이블명 where 조건;
       delete from test where id = 1;
   - 선택 select
         -select * from all_tables; 모든 테이블을 확인한다 쓰는거아님
         -select * from user_tables;
         select * from test order by score desc ; 오름차순
         select * from test order by score asc ; 내림차순
         
         SQL> select * from test where score >= 90; 90점이상 출력
         SQL> select * from test where score >= 90 and score < 100;
                                          100점미만 출력
         select * from test where score < 90 or score > 100;
                              90점 미만 100초과 출력
         select * from test where score is null;
         select * from test where name like '%규'; 문자열 찾아오기
         select * from test where name like '_규'; 
         select * from test where name like '한%'; 한씨 출력
         
   - 권한 부여 grant
   - 권한 박탈 rovoke

### Type
   ## 원시 타입
      
      # 숫자 
      Number = Integer | short | long
      Float = Double | Float   
      
      # 문자
      - Char = acter = 고정길이, max : 2000byte
      - varChar2 (mySQL > VarChar) = Char보다는 더 넣을 수 있다. 
                           가변길이 용량에 따라 변한다. max = 4000byte
      - Long = String > 길이에 대한 조건아 없다. max : 2gb
      - NChar = 유니코드 텍스트 
      - NVarChar = 유니코드 텍스트
      - Clob = Long보다 크다. 4gb
      - NClob = 유니코드 텍스트
      # 기타
      - Date > 날짜
      - Timestamp > 시간(기간)
   
## Option
   ### NOT NULL > (NULLABLE)   
   ### DEFAULT : 기본값
   ### UNIQUE : 중복 체크      
       -보통 NOT NULL이랑 같이 쓴다.
   
   아래 두개는 이름을 붙여줘야하고 위에 3개는 안붙여줘도 상관없다.
   
   ### PRIMARY KEY : 기본키
      - ㄴ 유일한 컬럼
      - NOT NULL + UNIQUE
      - 관계를 맺을 때 쓴다.
   ### FOREIGN KEY : 외래키 
      - 관계 맺을 때 씀
      - 관계에 대한 이름 ex)교수님과 학생의 관계가 무슨관계인가?
   
   
   
   ## 참조 타입 DB에서는 없음

테이블을 생성한다 > create
이름,타입, 데이터의 길이
Number(10,10) (Precision : 전체 길이, Scale : 소수점 이후의 길이
Float(10) (Precision : 전체 갈이) 
Char(10)
VarChar(10)
Long

## DB
   - 데이터를 어떻께 저장을 할까?
   - DataBase || SChema를 생성한다. create
   - DB에 속하는 테이블을 생성한다. create
   - 생성한 테이블에 데이터를 넣는다. insert
   - 생성한 테이블에서 데이터를 가져온다. select
   
   
## RDBMS
   - Relational DataBase Management System 
   - 관계형 데이터 베이스
   
## 비관계형 데이터 베이스
   - noSQL
   
# JSON
   - 우리가 다루는 데이터(객체, 스트링, 배열) -> 문자열로 바꿔준다.
   - "안녕하세요 저는 누구입니다." > 문자열
   - ["안녕하세요, 저는 누구입니다."] > 배열 > 안녕하세요,저는 누구입니다.
   - JSON이라는 형태로 바꿔주면 ["안녕하세요, 저는 누구입니다."] 배열을 다 보낸다.
   - {name:"홍길동"} > -{"name":"홍길동"} 앞에 키를 String으로 바꿔준다.
   
    
    
    
    
*/





}
