/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.fpmislata.domain.Categoria;
import com.fpmislata.service.CategoriaServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
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
@Path("/CategoriaService")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
@Stateless
public class CategoriaServiceREST {

    @EJB
    private CategoriaServiceLocal categoriaService;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @GET
    @Produces("application/json;charset=UTF-8")
    @Path("/Categorias")
    public List listarCategorias() {
        return categoriaService.listCategorias();
    }
    
    @GET
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    @Path("/Categorias/findById/{id}")
    public Categoria findCategoriaById(@PathParam("id") int id){
        Categoria c = new Categoria();
        c.setId(id);
        c = categoriaService.findCategoriaById(c);
        return c;
    }

    @POST
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    @Path("/Categorias/add")
    public Response addCategoria(Categoria categoria) {
        try{
            categoriaService.addCategoria(categoria);
            return Response.ok().entity(categoria).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
        }catch(Exception e){
            e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
