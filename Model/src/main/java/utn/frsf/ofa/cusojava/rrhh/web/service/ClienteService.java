package utn.frsf.ofa.cusojava.rrhh.web.service;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import utn.frsf.ofa.cusojava.rrhh.web.modelo.Cliente;
import utn.frsf.ofa.cusojava.rrhh.web.modelo.Contratado;
import utn.frsf.ofa.cusojava.rrhh.web.modelo.Efectivo;
import utn.frsf.ofa.cusojava.rrhh.web.modelo.Empleado;
import utn.frsf.ofa.cusojava.rrhh.web.modelo.Proyecto;

@Stateless(name = "ClienteService", mappedName = "Lab9-Modelo-ClienteService")
@Local
public class ClienteService {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "RRHH_WEB_PU")
    private EntityManager em;

    public ClienteService() {
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

    public Empleado persistEmpleado(Empleado empleado) {
        em.persist(empleado);
        return empleado;
    }

    public Empleado mergeEmpleado(Empleado empleado) {
        return em.merge(empleado);
    }

    public void removeEmpleado(Empleado empleado) {
        empleado = em.find(Empleado.class, empleado.getId());
        em.remove(empleado);
    }

    public Proyecto persistProyecto(Proyecto proyecto) {
        em.persist(proyecto);
        return proyecto;
    }

    public Proyecto mergeProyecto(Proyecto proyecto) {
        return em.merge(proyecto);
    }

    public void removeProyecto(Proyecto proyecto) {
        proyecto = em.find(Proyecto.class, proyecto.getId());
        em.remove(proyecto);
    }

    public Efectivo persistEfectivo(Efectivo efectivo) {
        em.persist(efectivo);
        return efectivo;
    }

    public Efectivo mergeEfectivo(Efectivo efectivo) {
        return em.merge(efectivo);
    }

    public void removeEfectivo(Efectivo efectivo) {
        efectivo = em.find(Efectivo.class, efectivo.getId());
        em.remove(efectivo);
    }

    public Contratado persistContratado(Contratado contratado) {
        em.persist(contratado);
        return contratado;
    }

    public Contratado mergeContratado(Contratado contratado) {
        return em.merge(contratado);
    }

    public void removeContratado(Contratado contratado) {
        contratado = em.find(Contratado.class, contratado.getId());
        em.remove(contratado);
    }

    public Cliente persistCliente(Cliente cliente) {
        em.persist(cliente);
        return cliente;
    }
    
    public List<Cliente> todos() {
        return em.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
    }

    public Cliente mergeCliente(Cliente cliente) {
        return em.merge(cliente);
    }

    public void removeCliente(Cliente cliente) {
        cliente = em.find(Cliente.class, cliente.getId());
        em.remove(cliente);
    }
}
