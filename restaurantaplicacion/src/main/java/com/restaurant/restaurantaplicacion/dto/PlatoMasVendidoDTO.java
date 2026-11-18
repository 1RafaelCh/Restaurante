package com.restaurant.restaurantaplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlatoMasVendidoDTO {

    private String nombrePlato;
    private Long cantidadVendida;
}
