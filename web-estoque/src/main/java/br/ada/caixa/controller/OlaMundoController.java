package br.ada.caixa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaMundoController {

    @GetMapping("/ola-mundo")
    public String olaMundo() {
        return "Olá mundo - 8080!";
    }
}
