package com.example.apilenta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Alumne {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nom;
  private String cognom;
  private String cicle;
  private String modalitat;
  private String estatPractiques;

  @ManyToOne()
  private Empresa empresa;
}
