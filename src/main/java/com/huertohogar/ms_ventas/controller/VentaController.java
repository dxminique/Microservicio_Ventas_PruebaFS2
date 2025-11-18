package com.huertohogar.ms_ventas.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huertohogar.ms_ventas.model.Venta;
import com.huertohogar.ms_ventas.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")

public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    //prueba para conectar con el gateway xd
    @GetMapping("/ping")
    public String ping() {
        return "ms-ventas OK";
    }

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nueva = ventaService.crearVenta(venta);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }
}

