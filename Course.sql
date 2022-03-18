
DROP TABLE Course;
TRUNCATE TABLE Course;
CREATE TABLE Course (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(100) UNIQUE NOT NULL, 
	Tutor VARCHAR(100) NOT NULL,
	Duration VARCHAR(100)  NOT NULL,
	URL VARCHAR(500)
);
SELECT * FROM Course; 

INSERT INTO Course(NAME,Tutor,Duration,URL) VALUES ('Java','Mosh Hamedani','2.3hrs','https://youtu.be/eIrMbAQSU34');
INSERT INTO Course(NAME,Tutor,Duration,URL) VALUES ('C Programming','Mike Dane','3.5hrs','https://youtu.be/KJgsSFOSQv0');
INSERT INTO Course(NAME,Tutor,Duration,URL) VALUES ('Python','Edureka','12hrs','https://youtu.be/WGJJIrtnfpk');