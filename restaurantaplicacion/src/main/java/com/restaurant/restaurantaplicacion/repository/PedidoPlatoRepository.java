package com.restaurant.restaurantaplicacion.repository;

import com.restaurant.restaurantaplicacion.model.PedidoPlato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoPlatoRepository extends JpaRepository<PedidoPlato, Long> {

    @Query("""
        SELECT pp.plato.nombre, SUM(pp.cantidad)
        FROM PedidoPlato pp
        GROUP BY pp.plato.nombre
        ORDER BY SUM(pp.cantidad) DESC
    """)
    List<Object[]> obtenerPlatosMasVendidos();
}