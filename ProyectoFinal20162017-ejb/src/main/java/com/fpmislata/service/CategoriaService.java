/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Categoria;
import com.fpmislata.repository.CategoriaDaoLocal;
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
public class CategoriaService implements CategoriaServiceLocal {

    @EJB
    private CategoriaDaoLocal categoriaDao;

    @Resource
    private SessionContext contexts;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List listCategorias() {
        try {
            return categoriaDao.listCategorias();
        } catch (Exception e) {
            contexts.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Categoria findCategoriaById(Categoria categoria) {
        try{
            return categoriaDao.findCategoriaById(categoria);
        }catch(Exception e){
            contexts.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addCategoria(Categoria categoria) {
        try{
            categoriaDao.addCategoria(categoria);
        }catch(Exception e){
            contexts.setRollbackOnly();
            e.printStackTrace();
        }
    }

}
