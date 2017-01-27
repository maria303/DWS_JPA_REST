/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class CategoriaDao implements CategoriaDaoLocal {

    @PersistenceContext(unitName = "ProyectoFinal20162017PU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listCategorias() {
        List<Categoria> lista = em.createNamedQuery("categoria.findAll").getResultList();
        return lista;
    }

    @Override
    public void addCategoria(Categoria categoria) {
        em.persist(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        categoria = findCategoriaById(categoria);
        em.remove(categoria);
    }

    @Override
    public Categoria findCategoriaById(Categoria categoria) {
        return em.find(Categoria.class, categoria.getId());
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        em.merge(categoria);
    }
    
    
}
