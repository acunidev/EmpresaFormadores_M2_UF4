package com.example.apilenta.repository;

import com.example.apilenta.entity.Alumne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumneDao extends JpaRepository<Alumne, Long> {
}