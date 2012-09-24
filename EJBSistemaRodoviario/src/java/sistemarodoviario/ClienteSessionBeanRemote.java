/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.ejb.Remote;
import sistemarodoviario.jpa.*;

/**
 *
 * @author Marcelo
 */
@Remote
public interface ClienteSessionBeanRemote {
    
    
    public void init();

    public int RetornaCliente();
    
    public Cliente recebeClientePorID(Long id);
    
    public Cliente getCliente();

    public void setCliente(Cliente cliente);

    public boolean validaLogin(String login, String senha);

    public void salvar();

    public boolean salvar(Cliente c);

    public void trocarSenha(String s);
    
    public long findIDCliente(String usuarioCliente);

    @Override
    public String toString();
    
    
}
