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
import sistemarodoviario.jpa.Cliente;
import sistemarodoviario.jpa.Trajeto;
import sistemarodoviario.jpa.Viagem;

/**
 *
 * @author Marcelo
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ViagemSessionBean implements ViagemSessionBeanRemote {

    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Viagem viagem;

    @PostConstruct
    @Override
    public void init() {
        em = emf.createEntityManager();
        viagem = new Viagem();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.merge(viagem);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Viagem v) {
        em = null;
        em = emf.createEntityManager();
        viagem = v;
        em.merge(viagem);

    }

    @Override
    public String toString() {
        return viagem.toString();
    }

    @Override
    public Viagem recebeViagemPorID(Long id) {
        Viagem v = em.find(Viagem.class, id);
        return v;
    }

    @Override
    public long findIDViagem(long cliente, long trajetoCliente,long onibusCliente,long assentoCliente) {

        em = null;
        em = emf.createEntityManager();

        try {

            Query query = em.createNativeQuery("SELECT u.ID_VIAGEM FROM VIAGEM u WHERE u.CLIENTE_FK=" + cliente + " AND " + "u.TRAJETO_FK=" + trajetoCliente + " AND " + "u.ONIBUS_FK=" + onibusCliente + " AND " + "u.ASSENTO_FK=" + assentoCliente);
            String result = query.getSingleResult().toString();

            return Long.parseLong(result);

        } catch (Exception e) {
            return -1;
        }
    }
}
