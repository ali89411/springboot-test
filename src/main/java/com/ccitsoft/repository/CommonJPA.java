package com.ccitsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccitsoft.domain.Teacher;

@Repository
public interface CommonJPA extends JpaRepository<Teacher, String>{
  
}
