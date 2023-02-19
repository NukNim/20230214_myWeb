DROP TABLE TEST_MEMBER CASCADE CONSTRAINTS;

CREATE TABLE TEST_MEMBER(
 ID CHAR(1),
 PASSWD VARCHAR2(15 BYTE) NOT NULL,
 NAME VARCHAR2(20 BYTE) NOT NULL,
 EMAIL VARCHAR2(30 BYTE),
 CONSTRAINT PK_MEMBER PRIMARY KEY (ID)
);
INSERT ALL
    INTO TEST_MEMBER VALUES('admin','admin', '관리자','admin@test.or.kr')
    INTO TEST_MEMBER VALUES('user11','pass11','사용자1','user11@test.or.kr')
    INTO TEST_MEMBER VALUES('user22','pass22','사용자2','user22@test.or.kr')
SELECT * FROM DUAL;
COMMIT;

DROP TABLE BOARD CASCADE CONSTRAINTS;

CREATE TABLE BOARD (
BOARD_NUM NUMBER, -- 게시글 번호
BOARD_TITLE VARCHAR2(50), -- 게시글 제목
BOARD_WRITER VARCHAR2(15), -- 게시글 작성자
BOARD_CONTENT VARCHAR2(2000), -- 게시글 내용
BOARD_ORIGINAL_FILENAME VARCHAR2(100), -- 업로드한 원래 파일명
BOARD_RENAME_FILENAME VARCHAR2(100), -- 바뀐 파일명
BOARD_DATE DATE DEFAULT SYSDATE,-- 게시글 올린 날짜
BOARD_LEVEL NUMBER DEFAULT 0,-- 글레벨 : 원글 0, 원글의 답글 1, 답글의 답글 2
BOARD_REF NUMBER, -- 원글일때는 자기번호, 답글일 때 참조하는 원글 번호
BOARD_REPLY_SEQ NUMBER DEFAULT 0, -- 답글의 순번
BOARD_READCOUNT NUMBER DEFAULT 0, -- 조회수
CONSTRAINT PK_BOARD PRIMARY KEY (BOARD_NUM),
CONSTRAINT FK_BOARD_WRITER FOREIGN KEY (BOARD_WRITER) REFERENCES TEST_MEMBER (ID) ON DELETE SET NULL,
CONSTRAINT FK_BOARD_REF FOREIGN KEY (BOARD_REF) REFERENCES BOARD (BOARD_NUM) ON DELETE CASCADE
);

select * from BOARD;

--원글 예시 insert 문
insert into board values((select nvl(max(board_num),0)+1 from board),
                    '&title','user11' ,'&content', null, null, DEFAULT,
                    DEFAULT, (select nvl(max(board_num),0)+1 from board), DEFAULT, DEFAULT); 
                    
                    
--1번글의 답글
insert into board values((select nvl(max(board_num),0)+1 from board),
                    '&title','user11' ,'&content', null, null, DEFAULT,
                    (select board_level+1 from board where board_num = 2),
                    (select board_ref from BOARD where board_num = 2),
                    (select nvl(max(board_ref),0)+1 from board where board_ref = '2'), DEFAULT);                     


update BOARD set BOARD_REPLY_SEQ = board_reply_seq +1 
    where BOARD_REPLY_SEQ > (select board_reply_seq from board where board_num = 2) 
    and board_ref = (select board_ref from board where board_num = 2);
    
   desc board; 
    
select board_num, BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAME_FILENAME,
BOARD_DATE, BOARD_LEVEL, BOARD_REF, BOARD_REPLY_SEQ, BOARD_READCOUNT from board;


commit;