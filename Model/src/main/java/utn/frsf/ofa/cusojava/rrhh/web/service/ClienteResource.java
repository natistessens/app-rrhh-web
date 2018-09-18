package utn.frsf.ofa.cusojava.rrhh.web.service;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import utn.frsf.ofa.cusojava.rrhh.web.modelo.Cliente;

@Stateless(name = "ClienteResource", mappedName = "Lab9-Modelo-ClienteResource")
@Path("/cliente")
public class ClienteResource {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "RRHH_WEB_PU")
    private EntityManager em;

    public ClienteResource() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    @GET
    public Response listarClientes() {
        return Response.ok("GET").build();
    }

    @POST
    public Response crearCliente(Cliente cli) {
        System.out.println("CLIENTE RECIBIDO : " + cli);
        return Response.ok("POST" + cli.getNombre()).build();
    }
}
