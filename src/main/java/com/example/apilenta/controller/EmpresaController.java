package com.example.apilenta.controller;

import com.example.apilenta.entity.Empresa;
import com.example.apilenta.repository.EmpresaDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The type Empresa controller.
 */
@Controller
@RequestMapping("api")
public class EmpresaController {

  /**
   * The Empresa dao.
   */
  final EmpresaDao empresaDao;

  /**
   * Instantiates a new Empresa controller.
   *
   * @param empresaDao the empresa dao
   */
  public EmpresaController(EmpresaDao empresaDao) {
    this.empresaDao = empresaDao;
  }

  /**
   * Empreses string.
   *
   * @param model the model
   * @return the string
   */
  @GetMapping("empreses")
  public String empreses(Model model) {

    model.addAttribute("empreses", empresaDao.findAll());

    return "llista-empreses";
  }

  /**
   * Mostrar formulari empresa string.
   *
   * @param model the model
   * @return the string
   */
  @GetMapping("/empreses/nou")
  public String mostrarFormulariEmpresa(Model model) {

    Empresa empresa = new Empresa();
    model.addAttribute("empresa", empresa);

    return "nova-empresa";
  }

  /**
   * Alta empresa string.
   *
   * @param empresa the empresa
   * @return the string
   */
  @PostMapping("empresa/alta")
  public String altaEmpresa(@Valid Empresa empresa, Errors errors) {
    if (errors.hasErrors()) {
      return "nova-empresa";
    }
    empresaDao.save(empresa);

    return "redirect:/api/empreses";
  }
}
