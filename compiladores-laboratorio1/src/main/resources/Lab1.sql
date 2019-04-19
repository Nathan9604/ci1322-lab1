USE Lab1_CI1322;

CREATE TABLE BOOK(
	Id			VARCHAR(256),
    Name 		VARCHAR(256),
    Author 		VARCHAR(256),
    Edition		INT,
    Genre		VARCHAR(256),
    
    PRIMARY KEY (Id)
);

CREATE TABLE STUDENT(
	Id			VARCHAR(256),
    Name		VARCHAR(256),
    Last_Name	VARCHAR(256),
    Num_Tel		VARCHAR(256),
    Age			INT,

	PRIMARY KEY (Id)
);

CREATE TABLE READ_ALREADY(
	Id_Student	VARCHAR(256),
    Id_Book		VARCHAR(256),
    
    FOREIGN KEY (Id_Student) REFERENCES STUDENT(Id)
    	ON UPDATE CASCADE
    	ON DELETE CASCADE,
    FOREIGN KEY (Id_Book) REFERENCES BOOK(Id)
    	ON UPDATE CASCADE
    	ON DELETE CASCADE,
    PRIMARY KEY (Id_Student, Id_Book)
);
