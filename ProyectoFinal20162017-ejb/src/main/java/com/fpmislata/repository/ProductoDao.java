/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class ProductoDao implements ProductoDaoLocal {

    @PersistenceContext(unitName = "ProyectoFinal20162017PU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listProductos() {
        return em.createNamedQuery("producto.findAll").getResultList();
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return em.find(Producto.class, producto.getId());
    }

    @Override
    public void addProducto(Producto producto) {
        em.persist(producto);
    }

    @Override
    public void updateProducto(Producto producto) {
        em.merge(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        producto = findProductoById(producto);
        em.remove(producto);
    }
}
