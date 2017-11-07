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
import petshop.Produto;

@Stateless
@Path("petshop.produto")
public class ProdutoFacadeREST extends AbstractFacade<Produto> {

    @PersistenceContext(unitName = "PetShopWebServicePU")
    private EntityManager em;

    public ProdutoFacadeREST() {
        super(Produto.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Produto entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Produto entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("search/{nome}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Produto> findByNome(@PathParam("nome") String nome) {
        return super.findByName(nome);
    }
    
    @GET
    @Path("searchType/{tipo}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Produto> findByType(@PathParam("tipo") int tipo) {
        Query query= getEntityManager().createNamedQuery("Produto.findByCdTipoProduto");
        query.setParameter("cdTipoProduto",tipo);
        return query.getResultList();
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Produto> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
