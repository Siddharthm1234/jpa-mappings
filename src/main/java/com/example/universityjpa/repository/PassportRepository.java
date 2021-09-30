package com.example.universityjpa.repository;

import com.example.universityjpa.entity.Passport;
import com.example.universityjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
}
