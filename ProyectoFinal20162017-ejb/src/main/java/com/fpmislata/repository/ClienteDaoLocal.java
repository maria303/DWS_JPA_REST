/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface ClienteDaoLocal {

    List listClientes();

    void addCliente(Cliente cliente);

    void deleteCliente(Cliente cliente);

    Cliente findClienteById(Cliente cliente);

    void updateCliente(Cliente cliente);

}
