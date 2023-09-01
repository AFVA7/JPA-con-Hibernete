package com.latam.alura.tienda.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items_pedido")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int cantidad;
	private BigDecimal precio_unitario;
	
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Producto producto;
	
	public ItemPedido() {
	}

	public ItemPedido(int cantidad, Pedido pedido, Producto producto) {
		this.cantidad = cantidad;
		this.pedido = pedido;
		this.producto = producto;
		this.precio_unitario = producto.getPrecio();
	}

	public Long getId() {
		return id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(BigDecimal precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public BigDecimal getValor() {
		return this.precio_unitario.multiply(new BigDecimal(this.cantidad));
	}
	
	
	
}
