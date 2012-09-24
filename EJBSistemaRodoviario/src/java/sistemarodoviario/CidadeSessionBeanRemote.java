/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import sistemarodoviario.jpa.Cidade;
import javax.ejb.Remote;

/**
 *
 * @author Marcelo
 */
@Remote
public interface CidadeSessionBeanRemote {

    public void init();

    public void salvar();

    public void salvar(Cidade c);

    public Cidade getCidade();

    public void setCidade(Cidade cidade);

    public Cidade findCidade(Long id);

    public long findIDCidade(String cidade);
    
    @Override
    public String toString();
}
