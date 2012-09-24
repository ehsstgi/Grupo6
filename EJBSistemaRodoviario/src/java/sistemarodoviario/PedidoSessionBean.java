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
import sistemarodoviario.jpa.Pedido;
import sistemarodoviario.jpa.Viagem;

/**
 *
 * @author Marcelo
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PedidoSessionBean implements PedidoSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Pedido pedido;

    @PostConstruct
    @Override
    public void init() {
        em = emf.createEntityManager();
        pedido = new Pedido();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.merge(pedido);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Pedido p) {
        em = null;
        em = emf.createEntityManager();
        pedido = p;
        em.merge(pedido);

    }

    @Override
    public String toString() {
        return pedido.toString();
    }

    @Override
    public Pedido recebePedidoPorID(Long id) {
        Pedido p = em.find(Pedido.class, id);
        return p;
    }

    @Override
    public List exibeDadosPedido(long cliente, long viagem) {
        em = null;
        em = emf.createEntityManager();
        List<Object[]> result = null;
        try {
            Query query = em.createNativeQuery("SELECT u.ID_PEDIDO FROM PEDIDO u WHERE u.CLIENTE_FK=" + cliente + " AND " + "u.VIAGEM_FK=" + viagem);
            result = query.getResultList();

            return result;

        } catch (Exception e) {
            return result;
        }
    }

    @Override
    public List exibeDadosPedido(long cliente) {
        em = null;
        em = emf.createEntityManager();
        List<Object[]> result = null;
        try {
            Query query = em.createNativeQuery("SELECT u.ID_PEDIDO FROM PEDIDO u WHERE u.CLIENTE_FK=" + cliente);
            result = query.getResultList();

            return result;

        } catch (Exception e) {
            return result;
        }
    }
}
