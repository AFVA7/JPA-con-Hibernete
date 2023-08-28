package com.latam.alura.tienda.test;


import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.model.Categoria;
import com.latam.alura.tienda.model.Producto;
import com.latam.alura.tienda.util.JPAUtil;

public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtil.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		Producto producto = productoDAO.consultaPorID(1L);
		System.out.println(producto.getNombre());
		
		BigDecimal precio = productoDAO.consultarPrecioPorNombreDeProducto("Xiami redmi");
		System.out.println(precio);
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
