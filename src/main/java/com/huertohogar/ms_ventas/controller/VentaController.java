package com.huertohogar.ms_ventas.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ventas")

public class VentaController {

    @GetMapping("/ping")
    public String ping() {
        return "ms-ventas OK";
    }
}

