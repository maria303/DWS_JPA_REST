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
    @Path("/Productos")
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
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
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
    
    @PUT
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    @Path("/Producto/update/{id}")
    public Response updateProducto(@PathParam("id") int id, Producto productoModificado){
        try{
            Producto p = new Producto();
            p.setId(id);
            p = productoService.findProductoById(p);
            if(p!=null){
                p.setNombre(productoModificado.getNombre());
                p.setPrecio(productoModificado.getPrecio());
                p.setCategoria(productoModificado.getCategoria());
                return Response.ok().entity(p).build();
            }else{
                return Response.status(Status.NOT_FOUND).build();
            }
        }catch(Exception e){
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    @Path("/Producto/delete/{id}")
    public Response deleteProductoById(@PathParam("id") int id){
        try{
            Producto p = new Producto();
            p.setId(id);
            productoService.deleteProducto(p);
            return Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
        }catch(Exception e){
            return Response.status(404).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
        }
    }
}
