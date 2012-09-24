/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.ejb.Remote;
import sistemarodoviario.jpa.Onibus;
import sistemarodoviario.jpa.Trajeto;

/**
 *
 * @author Marcelo
 */
@Remote
public interface TrajetoSessionBeanRemote {

    public void init();

    public Trajeto recebeTrajetoPorID(Long id);

    public long findIDTrajeto(long origem, long destino, String dataIda, String dataDestino);

    @Override
    public String toString();
}
