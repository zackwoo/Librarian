create table borrower (
  ID int not null,
  Name VARCHAR(50) not null,
  Email VARCHAR(100) not null,
  Password VARCHAR(20) not null ,
  Status INT NOT NULL ,
  constraint pk_borrower primary key (ID)
);


create table book (
  ISBN VARCHAR(20) NOT NULL ,
  Name VARCHAR (100) NOT NULL,
  Intro varchar(500) NOT NULL,
  BookCount INT not NULL ,
  constraint pk_book primary key (ISBN)
);

--借书记录
CREATE TABLE book_borrowing_record(
  ID INT NOT NULL ,
  BorrowerID INT NOT NULL ,
  ISBN VARCHAR(20) NOT NULL ,
  BorrowTime DATE NOT NULL ,
  ReturnTime DATE NULL ,
  IsOver BIT DEFAULT 0,
  CONSTRAINT pk_book_borrowing_record PRIMARY KEY (ID)
);
