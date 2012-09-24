/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import javax.ejb.Remote;
import sistemarodoviario.jpa.Cliente;
import sistemarodoviario.jpa.Trajeto;
import sistemarodoviario.jpa.Viagem;

/**
 *
 * @author Marcelo
 */
@Remote
public interface ViagemSessionBeanRemote {

    public void init();

    public void salvar();

    public void salvar(Viagem v);

    @Override
    public String toString();

    public Viagem recebeViagemPorID(Long id);

    public long findIDViagem(long cliente, long trajetoCliente, long onibusCliente, long assentoOnibus);
}
