package com.senai.escola.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.escola.Models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
