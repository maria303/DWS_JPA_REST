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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
    @Produces({"application/json"})
    @Path("/Clientes")
    public List listarClientes() {
        return clienteService.ListClientes();
    }

    @GET
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/Cliente/findById/{id}")
    public Cliente findClienteById(@PathParam("id") int id) {
        Cliente c = new Cliente();
        c.setId(id);
        c = clienteService.findClienteById(c);
        return c;
    }
    
    @POST
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/Cliente/add")
    public Response addCliente(Cliente cliente){
        try{
            clienteService.addCliente(cliente);
            return Response.ok().entity(cliente).build();
        }catch(Exception e){
            e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/Cliente/update/{id}")
    public Response updateCliente(@PathParam("id") int id, Cliente clienteModificado){
        try{
            Cliente c = new Cliente();
            c.setId(id);
            c = clienteService.findClienteById(c);
            if(c!=null){
                c.setNombre(clienteModificado.getNombre());
                c.setApellidos(clienteModificado.getApellidos());
                c.setNif(clienteModificado.getNif());
                c.setDireccion(clienteModificado.getDireccion());
                c.setPoblacion(clienteModificado.getPoblacion());
                c.setProvincia(clienteModificado.getProvincia());
                c.setCodigo_postal(clienteModificado.getCodigo_postal());
                c.setTelefono(clienteModificado.getTelefono());
                return Response.ok().entity(c).build();
            }else{
                return Response.status(Status.NOT_FOUND).build();
            }
        }catch(Exception e){
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Produces({"application/json"})
    @Consumes({"application/json"})
    @Path("/Cliente/delete/{id}")
    public Response deleteClienteById(@PathParam("id") int id){
        try{
            Cliente c = new Cliente();
            c.setId(id);
            clienteService.deleteCliente(c);
            return Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
        }catch(Exception e){
            return Response.status(404).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
        }
    }
}
