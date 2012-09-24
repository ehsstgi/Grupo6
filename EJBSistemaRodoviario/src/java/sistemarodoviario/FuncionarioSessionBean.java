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
import sistemarodoviario.jpa.Funcionario;

/**
 *
 * @author Marcelo
 */
@Stateful //(mappedName = "ejb/Funcionario")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FuncionarioSessionBean implements FuncionarioSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceUnit(unitName = "EJBSistemaRodoviarioPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private Funcionario funcionario;

    @PostConstruct
    @Override
    public void init() {
        em = emf.createEntityManager();
        funcionario = new Funcionario();
    }

    @Override
    public Funcionario getFuncionario() {
        return funcionario;
    }

    @Override
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public Funcionario recebeFuncionarioPorID(Long id) {
        Funcionario f = em.find(Funcionario.class, id);
        return f;
    }

    @Override
    public void trocarSenha(String s) {
        funcionario.setSenhaFunc(s);
        this.salvar();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.merge(funcionario);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Funcionario f) {
        em = null;
        em = emf.createEntityManager();
        funcionario = f;
        em.merge(funcionario);

    }

    @Override
    public boolean validaLogin(String login, String senha) {

        em = null;
        em = emf.createEntityManager();
        //String comando = "SELECT u.USUARIO_FUNC FROM CLIENTES u WHERE u.USUARIO_FUNC="+"'"+login+"'";

        try {

            Query query = em.createNativeQuery("SELECT u.USUARIO_FUNC FROM FUNCIONARIO u WHERE u.USUARIO_FUNC=" + "'" + login + "'" + " AND " + "u.SENHA_FUNC=" + "'" + senha + "'");
            String result = query.getSingleResult().toString();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public String toString() {
        return funcionario.toString();
    }
}
