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
import sistemarodoviario.jpa.Cliente;

/**
 *
 * @author Marcelo
 */
@Stateful //(mappedName = "ejb/Cliente")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClienteSessionBean implements ClienteSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    EntityManagerFactory emf;
    private Cliente cliente;
    private EntityManager em;
    private List<Cliente> resultados;

    @PostConstruct
    @Override
    public void init() {
        cliente = new Cliente();
        em = emf.createEntityManager();
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public Cliente recebeClientePorID(Long id) {
        Cliente c = em.find(Cliente.class, id);
        return c;
    }

    @Override
    public int RetornaCliente() {
        em = null;
        em = emf.createEntityManager();
        return em.createQuery("SELECT * FROM CLIENTES").getResultList().size();
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void trocarSenha(String s) {
        cliente.setSenhaCliente(s);
        this.salvar();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.merge(cliente);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean salvar(Cliente c) {
        em = null;
        em = emf.createEntityManager();
        try {

            cliente = c;
            em.merge(cliente);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean validaLogin(String login, String senha) {

        em = null;
        em = emf.createEntityManager();
        //String comando = "SELECT u.nome FROM CLIENTES u WHERE u.NOME="+"'"+login+"'";

        try {

            Query query = em.createNativeQuery("SELECT u.USUARIO_CLIENTE FROM CLIENTE u WHERE u.USUARIO_CLIENTE=" + "'" + login + "'" + " AND " + "u.SENHA_CLIENTE=" + "'" + senha + "'");
            String result = query.getSingleResult().toString();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public String toString() {
        return cliente.toString();
    }

    @Override
    public long findIDCliente(String usuarioCliente) {

        em = null;
        em = emf.createEntityManager();

        try {

            Query query = em.createNativeQuery("SELECT u.ID_CLIENTE FROM CLIENTE u WHERE u.USUARIO_CLIENTE=" + "'" + usuarioCliente + "'");
            String result = query.getSingleResult().toString();

            return Long.parseLong(result);

        } catch (Exception e) {
            return -1;
        }
    }
}
