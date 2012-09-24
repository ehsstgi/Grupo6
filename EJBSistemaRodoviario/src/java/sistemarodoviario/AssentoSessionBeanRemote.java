/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.ejb.Remote;
import sistemarodoviario.jpa.Assento;

/**
 *
 * @author Marcelo
 */
@Remote
public interface AssentoSessionBeanRemote {

    public void init();

    public void salvar();

    public void salvar(Assento a);

    public Assento getAssento();

    public void setAssento(Assento a);

    public Assento findAssento(Long id);

   public List exibeDisponibilidadeOnibus();

    @Override
    public String toString();
}
