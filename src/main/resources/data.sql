--ONE TO ONE
--Passport table added before Student table where it is (FK)
insert into passport (passport_number) values ('E3N21432');
insert into passport (passport_number) values ('R1T43986');
insert into passport (passport_number) values ('Z1T65480');

insert into student (first_name, last_name, email_id, passport_id) values ('Siddharth', 'Mehta', 's@gmail.com',1);
insert into student (first_name, last_name, email_id, passport_id) values ('Aman', 'Gupta', 'aman@gmail.com',2);
insert into student (first_name, last_name, email_id, passport_id) values ('Avi', 'Aryan', 'avi@gmail.com',3);

--ONE(Course) TO MANY(reviews)
--Course table added before Review table where it is (FK)
insert into course (course_title, credit) values ('Java Course', 5);
insert into course (course_title, credit) values ('Spring Course', 4);
insert into course (course_title, credit) values ('React Course', 3);


insert into review (rating, description, course_id) values ('3', 'Good Java course, could be better', 1);
insert into review (rating, description, course_id) values ('5', 'Awesome Java course', 1);
insert into review (rating, description, course_id) values ('5', 'Loved it course', 2);
insert into review (rating, description, course_id) values ('5', 'Spring <3', 2);

--MANY(Student) TO MANY(Course)
--Student & Course entity to be added before student_course table where it is (FK)
insert into student_course (student_id, course_id) values (1, 1);
insert into student_course (student_id, course_id) values (1, 2);
insert into student_course (student_id, course_id) values (3, 3);