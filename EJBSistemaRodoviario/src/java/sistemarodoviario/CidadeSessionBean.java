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
import sistemarodoviario.jpa.Cidade;

/**
 *
 * @author Marcelo
 */
@Stateful //(mappedName = "ejb/Cidade")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CidadeSessionBean implements CidadeSessionBeanRemote {

    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Cidade cidade;

    @PostConstruct
    @Override
    public void init() {
        em = emf.createEntityManager();
        cidade = new Cidade();
    }

    @Override
    public Cidade getCidade() {
        return cidade;
    }

    @Override
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public Cidade findCidade(Long id) {
        em = null;
        em = emf.createEntityManager();
        Cidade c = em.find(Cidade.class, id);
        return c;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.merge(cidade);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Cidade c) {
        em = null;
        em = emf.createEntityManager();
        cidade = c;
        em.merge(cidade);

    }

    @Override
    public long findIDCidade(String cidade) {

        em = null;
        em = emf.createEntityManager();

        try {

            Query query = em.createNativeQuery("SELECT u.ID_CIDADE FROM CIDADE u WHERE u.NOME_CIDADE=" + "'" + cidade + "'");
            String result = query.getSingleResult().toString();

            return Long.parseLong(result);

        } catch (Exception e) {
            return -1;
        }

    }

    @Override
    public String toString() {
        return cidade.toString();
    }
}
