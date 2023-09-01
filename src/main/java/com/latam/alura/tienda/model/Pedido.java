package com.latam.alura.tienda.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha = LocalDate.now();
	@Column(name = "valos_total")
	private BigDecimal valor_total = new BigDecimal(0);
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itemsPedidos = new ArrayList<>();

	public Pedido() {
	}
	
	public void agregarItems(ItemPedido item) {
		item.setPedido(this);
		itemsPedidos.add(item);
		this.valor_total = this.valor_total.add(item.getValor());
	}
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public BigDecimal getValor_total() {
		return valor_total;
	}



	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}


}
