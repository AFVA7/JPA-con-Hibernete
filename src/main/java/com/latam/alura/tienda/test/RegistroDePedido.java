package com.latam.alura.tienda.test;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ClienteDAO;
import com.latam.alura.tienda.dao.PedidoDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.model.Categoria;
import com.latam.alura.tienda.model.Cliente;
import com.latam.alura.tienda.model.ItemPedido;
import com.latam.alura.tienda.model.Pedido;
import com.latam.alura.tienda.model.Producto;
import com.latam.alura.tienda.util.JPAUtil;
import com.latam.alura.tienda.vo.RelatorioDeVentas;

public class RegistroDePedido {

	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtil.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		Producto producto = productoDAO.consultaPorID(1l);
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		
		Cliente cliente = new Cliente("Juan", "1113313722");
		Pedido pedido = new Pedido(cliente);
		pedido.agregarItems(new ItemPedido(5, pedido, producto));
		
		em.getTransaction().begin();
		
		clienteDAO.guardar(cliente);
		pedidoDAO.guardar(pedido);
		
		em.getTransaction().commit();
		
		BigDecimal valorTotal = pedidoDAO.valorTotalVendido();
		System.out.println("Valor Total " + valorTotal);
		
		List<RelatorioDeVentas> relatorio = pedidoDAO.relatorioDeVentasVO();
		
		relatorio.forEach(System.out::println);
	}

	public static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Xiami redmi", "Muy legal", new BigDecimal("1000"), celulares);
		EntityManager em = JPAUtil.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new  CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		em.getTransaction().commit();
		em.close();
	}

}
