package com.example.apilenta.repository;

import com.example.apilenta.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaDao extends JpaRepository<Empresa, String> {
}
