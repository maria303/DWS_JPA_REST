/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import com.fpmislata.repository.ClienteDaoLocal;
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
public class ClienteService implements ClienteServiceLocal {

    @EJB
    private ClienteDaoLocal clienteDao;

    @Resource
    private SessionContext contexts;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List ListClientes() {
        try {
            return clienteDao.listClientes();
        } catch (Exception e) {
            contexts.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cliente findClienteById(Cliente cliente) {
        try{
            return clienteDao.findClienteById(cliente);
        }catch(Exception e){
            contexts.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }
}
