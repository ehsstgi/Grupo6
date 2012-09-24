/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import sistemarodoviario.jpa.Estado;

/**
 *
 * @author Marcelo
 */
@Stateful //(mappedName = "ejb/Estado")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EstadoSessionBean implements EstadoSessionBeanRemote {

    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    EntityManagerFactory emf;
    private EntityManager em;
    private Estado estado;
    private List<Estado> resultados;

    @PostConstruct
    @Override
    public void init() {
        estado = new Estado();
        em = emf.createEntityManager();
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public List<Estado> listarCidades() {
        return resultados;
    }

    @Override
    public Estado findEstado(Long id) {
        Estado e = em.find(Estado.class, id);
        return e;
    }

    @Override
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.merge(estado);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Estado e) {
        em = null;
        em = emf.createEntityManager();
        estado = e;
        em.merge(estado);
    }

    @Override
    public String toString() {
        return estado.toString();
    }

    @Override
    public long findIDEstado(String estado) {

        em = null;
        em = emf.createEntityManager();

        try {

            Query query = em.createNativeQuery("SELECT u.ID_ESTADO FROM ESTADO u WHERE u.NOME_ESTADO=" + "'" + estado + "'");
            String result = query.getSingleResult().toString();

            return Long.parseLong(result);

        } catch (Exception e) {
            return -1;
        }

    }
    
    
    
    
}
