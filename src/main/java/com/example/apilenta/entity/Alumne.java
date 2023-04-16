package com.example.apilenta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

  @NotBlank(message = "Has d'introduir un nom")
  @Size(min = 2, max = 50)
  private String nom;

  @NotBlank(message = "Has d'introduir un cognom")
  @Size(min = 2, max = 50)
  private String cognom;

  @NotBlank(message = "Has d'introduir un cicle")
  @Size(min = 3, max = 4)
  private String cicle;

  private String modalitat;

  private String estatPractiques;

  @ManyToOne()
  private Empresa empresa;
}
