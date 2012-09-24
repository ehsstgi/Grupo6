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
import sistemarodoviario.jpa.Assento;

/**
 *
 * @author Marcelo
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AssentoSessionBean implements AssentoSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Assento assento;

    @PostConstruct
    @Override
    public void init() {
        em = emf.createEntityManager();
        assento = new Assento();
    }

    @Override
    public Assento getAssento() {
        return assento;
    }

    @Override
    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    @Override
    public Assento findAssento(Long id) {
        em = null;
        em = emf.createEntityManager();
        Assento a = em.find(Assento.class, id);
        return a;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.merge(assento);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Assento a) {
        em = null;
        em = emf.createEntityManager();
        assento = a;
        em.merge(assento);

    }

    @Override
    public List exibeDisponibilidadeOnibus() {
        em = null;
        em = emf.createEntityManager();

        try {
            Query query = em.createNativeQuery("SELECT DISPONIBILIDADE FROM ASSENTO");
            List result = query.getResultList();

            return result;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return assento.toString();
    }
}
