/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class PedidoDao implements PedidoDaoLocal {

    @PersistenceContext(unitName = "ProyectoFinal20162017PU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Pedido> listPedidos() {
        List<Pedido> lista = em.createNamedQuery("pedido.findAll").getResultList();
        return lista;
    }
}
