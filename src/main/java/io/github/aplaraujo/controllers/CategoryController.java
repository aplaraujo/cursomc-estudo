package io.github.aplaraujo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categories")
public class CategoryController {

    @GetMapping
    public String listar() {
        return "REST está funcionando!";
    }
}
