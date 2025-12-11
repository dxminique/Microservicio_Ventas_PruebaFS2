package com.huertohogar.ms_ventas.controller;

import com.huertohogar.ms_ventas.model.Venta;
import com.huertohogar.ms_ventas.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "venta-controller",
        description = "Operaciones para gestionar ventas de HuertoHogar"
)
@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @Operation(
            summary = "Comprobar estado del microservicio de ventas",
            description = "Devuelve un texto simple para verificar que el microservicio está operativo."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Microservicio respondiendo correctamente")
    })
    @GetMapping("/ping")
    public String ping() {
        return "ms-ventas OK";
    }

    @Operation(
            summary = "Listar todas las ventas",
            description = "Obtiene la lista completa de ventas registradas."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de ventas obtenida correctamente")
    })
    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @Operation(
            summary = "Listar ventas por usuario",
            description = "Obtiene todas las ventas asociadas al correo del cliente."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ventas del usuario obtenidas correctamente")
    })
    @GetMapping("/usuario/{email}")
    public ResponseEntity<List<Venta>> listarPorUsuario(
            @Parameter(description = "Correo del cliente para filtrar las ventas", example = "cliente@correo.com")
            @PathVariable String email
    ) {
        List<Venta> ventas = ventaService.listarPorCliente(email);
        return ResponseEntity.ok(ventas);
    }

    @Operation(
            summary = "Crear una venta",
            description = "Registra una nueva venta en el sistema."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Venta creada correctamente")
    })
    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nueva = ventaService.crearVenta(venta);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }
}
