package com.huertohogar.ms_ventas.repository;

import com.huertohogar.ms_ventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByCliente(String cliente);

}

