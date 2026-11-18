package com.restaurant.restaurantaplicacion.service;

import com.restaurant.restaurantaplicacion.dto.DashboardResumenDTO;
import com.restaurant.restaurantaplicacion.dto.PlatoMasVendidoDTO;
import com.restaurant.restaurantaplicacion.repository.ClienteRepository;
import com.restaurant.restaurantaplicacion.repository.PedidoPlatoRepository;
import com.restaurant.restaurantaplicacion.repository.PedidoRepository;
import com.restaurant.restaurantaplicacion.repository.PlatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
private PedidoPlatoRepository pedidoPlatoRepository;

    public DashboardResumenDTO obtenerResumen() {

        DashboardResumenDTO dto = new DashboardResumenDTO();

        dto.setTotalClientes(clienteRepository.count());
        dto.setTotalPlatos(platoRepository.count());
        dto.setTotalPedidos(pedidoRepository.count());

        dto.setVentasTotales(
                pedidoRepository.findAll()
                        .stream()
                        .mapToDouble(p -> p.getTotal())
                        .sum()
        );

        return dto;
    }

    public List<PlatoMasVendidoDTO> obtenerTopPlatos() {

    return pedidoPlatoRepository
            .obtenerPlatosMasVendidos()
            .stream()
            .map(resultado ->
                    new PlatoMasVendidoDTO(
                            (String) resultado[0],
                            ((Number) resultado[1]).longValue()
                    )
            )
            .toList();
}
}