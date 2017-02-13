/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.fpmislata.domain.Producto;
import com.fpmislata.service.ProductoServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Maria
 */
@Path("/ProductoService")
@Stateless
public class ProductoServiceRest {

    @EJB
    private ProductoServiceLocal productoService;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @GET
    @Produces({"application/json;charset=UTF-8"})
    @Path("Productos")
     public List<Producto> listarProductos() {
        return productoService.listProductos();
    }

    @GET
    @Produces({"application/json;charset=UTF-8"})
    @Path("/Productos/findById/{id}")
    public Producto findProductoById(@PathParam("id") int id) {
        Producto p = new Producto();
        p.setId(id);
        return productoService.findProductoById(p);
    }

    @POST
    @Produces({"application/json"})
    @Consumes({"application/xml", "application/json"})
    @Path("/Productos/add")
    public Response addProducto(Producto producto) {
        try{
            productoService.addProducto(producto);
            return Response.ok().entity(producto).build();
        }catch(Exception e){
            e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
