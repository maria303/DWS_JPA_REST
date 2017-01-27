/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.fpmislata.domain.Cliente;
import com.fpmislata.service.ClienteServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author alumno
 */
@Path("/ClienteService")
@Stateless
public class ClienteServiceREST {

    @EJB
    private ClienteServiceLocal clienteService;

    @GET
    @Produces({"application/xml","application/json"})
    @Path("/Clientes")
    public List<Cliente> listarClientes() {
        return clienteService.ListClientes();
    }

    @GET
    @Produces({"application/xml","application/json"})
    @Consumes({"application/xml","application/json"})
    @Path("/Cliente/findById/{id}")
    public Cliente findClienteById(@PathParam("id") int id) {
        Cliente c = new Cliente();
        c.setId(id);
        c = clienteService.findClienteById(c);
        return c;
    }
    
}
