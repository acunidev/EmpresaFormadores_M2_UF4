package com.example.apilenta.controller;


import com.example.apilenta.entity.Alumne;
import com.example.apilenta.repository.AlumneDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("api")
public class AlumneController {

    final AlumneDao alumneDAO;

    public AlumneController(AlumneDao alumneDAO) {
        this.alumneDAO = alumneDAO;
    }

    @GetMapping("alumnes")
    public String alumnes(Model model) {

        model.addAttribute("alumnes", alumneDAO.findAll());

        return "llista-alumnes";
    }

    @GetMapping("/alumnes/nou")
    public String mostrarFormulariProjecte(Model model) {

        Alumne alumne = new Alumne();
        model.addAttribute("alumne", alumne);


        return "nou-alumne";
    }

    @PostMapping("alumnes/alta")
    public String altaProjecte(Alumne alumne) {
        alumneDAO.save(alumne);

        return "redirect:/api/alumnes";
    }
}
