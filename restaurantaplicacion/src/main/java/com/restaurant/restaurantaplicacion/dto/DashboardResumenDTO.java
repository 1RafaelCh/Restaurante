package com.restaurant.restaurantaplicacion.dto;

import lombok.Data;

@Data
public class DashboardResumenDTO {

    private Long totalClientes;
    private Long totalPlatos;
    private Long totalPedidos;
    private Double ventasTotales;
}