/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PEDIDO")
    private Long id;
    @Column(name = "NOME_PASSAGEIRO")
    private String nomePassageiro;
    @Column(name = "CPF_PASSAGEIRO")
    private String cpfPassageiro;
    @Column(name = "DATA_COMPRA")
    private String dataCompra;
    @Column(name = "PAGO")
    private boolean pagoCompra;
    @ManyToOne
    @JoinColumn(name = "CLIENTE_FK")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "VIAGEM_FK")
    private Viagem viagem;
 
    public Pedido() {
    }

    public Pedido(String nomePassageiro, String cpfPassageiro, String dataCompra, boolean pagoCompra, Cliente cliente, Viagem viagem) {
        this.nomePassageiro = nomePassageiro;
        this.cpfPassageiro = cpfPassageiro;
        this.dataCompra = dataCompra;
        this.pagoCompra = pagoCompra;
        this.cliente = cliente;
        this.viagem = viagem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCpfPassageiro() {
        return cpfPassageiro;
    }

    public void setCpfPassageiro(String cpfPassageiro) {
        this.cpfPassageiro = cpfPassageiro;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public boolean isPagoCompra() {
        return pagoCompra;
    }

    public void setPagoCompra(boolean pagoCompra) {
        this.pagoCompra = pagoCompra;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Pedido[ id=" + id + " ]";
    }
}
