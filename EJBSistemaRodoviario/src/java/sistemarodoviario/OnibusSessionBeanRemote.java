/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import javax.ejb.Remote;
import sistemarodoviario.jpa.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
@Remote
public interface OnibusSessionBeanRemote {

    public void init();

    public Onibus recebeOnibusPorID(Long id);

    public Onibus getOnibus();

    public void setOnibus(Onibus onibus);

    public void salvar();

    public void salvar(Onibus o);

    public List exibeDadosOnibus();

    public long findIDOnibus(long trajeto);

    @Override
    public String toString();
}
