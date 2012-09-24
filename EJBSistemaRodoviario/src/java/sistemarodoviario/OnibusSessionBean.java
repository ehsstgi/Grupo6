/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import sistemarodoviario.jpa.Onibus;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OnibusSessionBean implements OnibusSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Onibus onibus;

    @PostConstruct
    @Override
    public void init() {
        em = emf.createEntityManager();
        onibus = new Onibus();
    }

    @Override
    public Onibus getOnibus() {
        return onibus;
    }

    @Override
    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    @Override
    public Onibus recebeOnibusPorID(Long id) {
        Onibus f = em.find(Onibus.class, id);
        return f;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.merge(onibus);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Onibus o) {
        em = null;
        em = emf.createEntityManager();
        onibus = o;
        em.merge(onibus);

    }

    @Override
    public String toString() {
        return onibus.toString();
    }

    @Override
    public List exibeDadosOnibus() {
        em = null;
        em = emf.createEntityManager();
        List<Object[]> result = null;
        try {
            Query query = em.createNativeQuery("SELECT o.NOME_EMPRESA FROM ONIBUS o");
            result = query.getResultList();

            return result;

        } catch (Exception e) {
            return result;
        }
    }

    @Override
    public long findIDOnibus(long trajeto) {

        em = null;
        em = emf.createEntityManager();

        try {

            Query query = em.createNativeQuery("SELECT u.ID_ONIBUS FROM ONIBUS u WHERE u.TRAJETO_FK=" + trajeto);

            String result = query.getSingleResult().toString();

            return Long.parseLong(result);

        } catch (Exception e) {
            return -1;
        }


    }
}
