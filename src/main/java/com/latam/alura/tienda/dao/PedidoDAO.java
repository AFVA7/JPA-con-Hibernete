package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.model.Pedido;
import com.latam.alura.tienda.vo.RelatorioDeVentas;

public class PedidoDAO {
	
	private EntityManager em;
	
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public void actualizar(Pedido pedido) {
		this.em.merge(pedido);
	}
	public void remover(Pedido pedido) {
		pedido = this.em.merge(pedido);
		this.em.remove(pedido);
	}
	
	public Pedido consultaPorID(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos() {
		String jpql = "SELECT P FROM Pedido AS P";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT MAX(p.valor_total) FROM Pedido p";
		return em.createQuery(jpql,BigDecimal.class).getSingleResult();
	}
	
	public Double valorPromedioVendido() {
		String jpql = "SELECT AVG(p.valor_total) FROM Pedido p";
		return em.createQuery(jpql,Double.class).getSingleResult();
	}
	
	public List<RelatorioDeVentas> relatorioDeVentasVO() {
		String jpql = "SELECT new com.latam.alura.tienda.vo.RelatorioDeVentas (p.nombre, "
				+ "SUM(item.cantidad), "
				+ "MAX(ped.fecha)) "
				+ "FROM Pedido ped "
				+ "JOIN ped.itemsPedidos item "
				+ "JOIN item.producto p "
				+ "GROUP BY p.nombre "
				+ "ORDER BY item.cantidad DESC";
		return em.createQuery(jpql,RelatorioDeVentas.class).getResultList();
	}
	
}
