package com.latam.alura.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVentas {
	
	private String nombreProducto;
	private Long CantidadProducto;
	private LocalDate FechaUltimaVenta;
	
	public RelatorioDeVentas(String nombreProducto, Long cantidadProducto, LocalDate fechaUltimaVenta) {
		this.nombreProducto = nombreProducto;
		CantidadProducto = cantidadProducto;
		FechaUltimaVenta = fechaUltimaVenta;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getCantidadProducto() {
		return CantidadProducto;
	}

	public void setCantidadProducto(Long cantidadProducto) {
		CantidadProducto = cantidadProducto;
	}

	public LocalDate getFechaUltimaVenta() {
		return FechaUltimaVenta;
	}

	public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
		FechaUltimaVenta = fechaUltimaVenta;
	}

	@Override
	public String toString() {
		return "relatorioDeVentas [nombreProducto=" + nombreProducto + ", CantidadProducto=" + CantidadProducto
				+ ", FechaUltimaVenta=" + FechaUltimaVenta + "]";
	}
	
	
	

}
