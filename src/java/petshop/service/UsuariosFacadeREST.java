/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import petshop.Usuarios;

/**
 *
 * @author Jess
 */
@Stateless
@Path("petshop.usuarios")
public class UsuariosFacadeREST extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "PetShopWebServicePU")
    private EntityManager em;

    public UsuariosFacadeREST() {
        super(Usuarios.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuarios entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Usuarios entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuarios find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuarios> findAll() {
        return super.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("{login}/{senha}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuarios autenticar(@PathParam("login") String login, @PathParam("senha") String senha) {
 
        Query query= getEntityManager().createNamedQuery("Usuarios.autenticar");
        query.setParameter("login",login);
        query.setParameter("senha",senha);
        List<Usuarios> usu = (List<Usuarios>) query.getResultList();
        if(usu.isEmpty()){
            return new Usuarios();
        }
        return usu.get(0);
    }
 
    @GET
    @Path("searchLogin/{login}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuarios findByLogin(@PathParam("login") String login) {
        Query query= getEntityManager().createNamedQuery("Usuarios.findByLogin");
        query.setParameter("login",login);
        List<Usuarios> usu = (List<Usuarios>) query.getResultList();
        if(usu.isEmpty()){
             return new Usuarios();
        }
        return usu.get(0);
    }
 
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
