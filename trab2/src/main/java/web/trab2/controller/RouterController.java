package web.trab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import web.trab2.repository.AlunoRepository;

@Controller
public class RouterController {

    @Autowired
    AlunoRepository repository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/novo")
    public String novoAluno() {
        return "novo";
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editNotas(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView("edit");
        /*
            Aqui você obtém do banco de dados um objeto Aluno a partir do id informado
            Se o aluno com o id existir nos dados, você injeta no Model & View o dto correspondente
         */
        return mv;
    }
}
