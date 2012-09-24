/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.ejb.Remote;
import sistemarodoviario.jpa.Pedido;
import sistemarodoviario.jpa.Viagem;

/**
 *
 * @author Marcelo
 */
@Remote
public interface PedidoSessionBeanRemote {

    public void init();

    public void salvar();

    public void salvar(Pedido p);

    @Override
    public String toString();

    public Pedido recebePedidoPorID(Long id);

    public List exibeDadosPedido(long cliente, long viagem);

    public List exibeDadosPedido(long cliente);
}
