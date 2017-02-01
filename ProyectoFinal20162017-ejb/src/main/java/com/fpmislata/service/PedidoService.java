/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Pedido;
import com.fpmislata.repository.PedidoDaoLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class PedidoService implements PedidoServiceLocal {

    @EJB
    private PedidoDaoLocal pedidoDao;

    @Resource
    private SessionContext contexts;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Pedido> listPedidos() {
        try {
            return pedidoDao.listPedidos();
        } catch (Exception e) {
            contexts.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }
}
