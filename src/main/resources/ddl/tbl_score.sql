

CREATE SEQUENCE seq_tbl_score;

CREATE TABLE tbl_score (
    stu_num NUMBER(10)
    , stu_name VARCHAR2(20) NOT NULL
    , kor NUMBER(3) NOT NULL
    , eng NUMBER(3) NOT NULL
    , math NUMBER(3) NOT NULL
    , total NUMBER(3)
    , average NUMBER(5,2)
    , grade CHAR(1)
    , CONSTRAINT pk_tbl_score PRIMARY KEY (stu_num)
);