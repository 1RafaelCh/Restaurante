package com.restaurant.restaurantaplicacion.controller;

import com.restaurant.restaurantaplicacion.dto.DashboardResumenDTO;
import com.restaurant.restaurantaplicacion.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.restaurant.restaurantaplicacion.dto.PlatoMasVendidoDTO;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/resumen")
    public DashboardResumenDTO resumen() {
        return dashboardService.obtenerResumen();
    }

    @GetMapping("/platos-mas-vendidos")
public List<PlatoMasVendidoDTO> platosMasVendidos() {
    return dashboardService.obtenerTopPlatos();
}
}
