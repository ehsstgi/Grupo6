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
import sistemarodoviario.jpa.Onibus;
import sistemarodoviario.jpa.Trajeto;

/**
 *
 * @author Marcelo
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TrajetoSessionBean implements TrajetoSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Trajeto trajeto;

    @PostConstruct
    @Override
    public void init() {
        em = emf.createEntityManager();
        trajeto = new Trajeto();
    }

    @Override
    public String toString() {
        return trajeto.toString();
    }

    @Override
    public Trajeto recebeTrajetoPorID(Long id) {
        Trajeto t = em.find(Trajeto.class, id);
        return t;
    }

    @Override
    public long findIDTrajeto(long origem, long destino, String dataIda, String dataDestino) {

        em = null;
        em = emf.createEntityManager();

        try {

            Query query = em.createNativeQuery("SELECT u.ID_TRAJETO FROM TRAJETO u WHERE u.CIDADE_ORIGEM=" + origem + " AND " + "u.CIDADE_DESTINO=" + destino + " AND " + "u.DATA_INICIO=" + "'" + dataIda + "'" + " AND " + "u.DATA_FIM=" + "'" + dataDestino + "'");

            String result = query.getSingleResult().toString();

            return Long.parseLong(result);

        } catch (Exception e) {
            return -1;
        }

    }
}
