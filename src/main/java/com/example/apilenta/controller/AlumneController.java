package com.example.apilenta.controller;


import com.example.apilenta.entity.Alumne;
import com.example.apilenta.repository.AlumneDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Alumne controller.
 */
@Controller()
@RequestMapping("api")
public class AlumneController {

  /**
   * The Alumne dao.
   */
  final AlumneDao alumneDAO;

  /**
   * Instantiates a new Alumne controller.
   *
   * @param alumneDAO the alumne dao
   */
  public AlumneController(AlumneDao alumneDAO) {
    this.alumneDAO = alumneDAO;
  }

  /**
   * Alumnes string.
   *
   * @param model the model
   * @return the string
   */
  @GetMapping("alumnes")
  public String alumnes(Model model) {

    model.addAttribute("alumnes", alumneDAO.findAll());

    return "llista-alumnes";
  }

  /**
   * Mostrar formulari projecte string.
   *
   * @param model the model
   * @return the string
   */
  @GetMapping("/alumnes/nou")
  public String mostrarFormulariProjecte(Model model) {

    Alumne alumne = new Alumne();
    model.addAttribute("alumne", alumne);


    return "nou-alumne";
  }

  /**
   * Alta projecte string.
   *
   * @param alumne the alumne
   * @return the string
   */
  @PostMapping("alumnes/alta")
  public String altaProjecte(Alumne alumne) {
    alumneDAO.save(alumne);

    return "redirect:/api/alumnes";
  }
}
