package com.example.apilenta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empresa {

  @Id
  private String cif;
  private long id;

  private String nom;
  private String adresa;

  @OneToMany(mappedBy = "empresa")
  private List<Alumne> alumnes;

}
