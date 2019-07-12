CREATE TABLE city
(
  id      INT PRIMARY KEY auto_increment,
  name    VARCHAR,
  state   VARCHAR,
  country VARCHAR
);

CREATE TABLE board
(
  id      LONG PRIMARY KEY auto_increment,
  title   VARCHAR2(40),
  content VARCHAR2(200)
);
