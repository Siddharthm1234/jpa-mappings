package com.example.universityjpa.repository;

import com.example.universityjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmail(String email);

    //Native
    @Query(value = "select * from student s where s.email_id=?1", nativeQuery = true)
    Student getStudentByEmailNative(String email);

    //Native - Named Param
    @Query(value = "select * from student s where s.email_id= :emailId", nativeQuery = true)
    Student getStudentByEmailNativeNamedParam(@Param("emailId") String email);


    @Modifying
    @Transactional // this goes in service method level - Generally
    @Query(value = "update student s set s.first_name=?1 where s.email_id=?2",nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);

    //@Query(value = "select s from Student s where s.courseId is null")
    List<Student> findByCoursesIsNull();
}
