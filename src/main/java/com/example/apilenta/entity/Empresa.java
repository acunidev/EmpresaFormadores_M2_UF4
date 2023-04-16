package com.example.apilenta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

  @NotBlank(message = "Has d'introduir el nom de la empresa")
  @Size(min = 2, max = 50)
  private String nom;

  @NotBlank(message = "Has d'introduir la direcció de la empresa")
  @Size(min = 2, max = 50)
  private String adresa;

  @OneToMany(mappedBy = "empresa")
  private List<Alumne> alumnes;

}
