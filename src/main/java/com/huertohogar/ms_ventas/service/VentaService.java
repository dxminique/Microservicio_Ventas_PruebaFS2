package com.huertohogar.ms_ventas.service;
import com.huertohogar.ms_ventas.model.Venta;
import com.huertohogar.ms_ventas.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public Venta crearVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public List<Venta> listarPorCliente(String cliente) {
        return ventaRepository.findByCliente(cliente);
    }

}
