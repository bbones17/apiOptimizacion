package edu.unsj.fcefn.lcc.optimizacion.api.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PresentationController {

    @GetMapping(value = "")
    public String index(){
            return "Nada";
        }

}
