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
@Table(name = "VIAGEM")
public class Viagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_VIAGEM")
    private Long id;
    @OneToOne(targetEntity = Trajeto.class)
    @JoinColumn(name = "TRAJETO_FK")
    private Trajeto trajeto;
    @OneToOne(targetEntity = Onibus.class)
    @JoinColumn(name = "ONIBUS_FK")
    private Onibus onibus;
    @OneToOne(targetEntity = Assento.class)
    @JoinColumn(name = "ASSENTO_FK")
    private Assento assento;
    @ManyToOne
    @JoinColumn(name = "CLIENTE_FK")
    private Cliente cliente;
    @OneToMany(mappedBy = "viagem", targetEntity = Pedido.class)
    private List<Pedido> pedidos;

    public Viagem() {
    }

    public Viagem(Trajeto trajeto, Onibus onibus, Assento assento, Cliente cliente) {
        this.trajeto = trajeto;
        this.onibus = onibus;
        this.assento = assento;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Trajeto getTrajeto() {
        return trajeto;
    }

    public void setTrajeto(Trajeto trajeto) {
        this.trajeto = trajeto;
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
        if (!(object instanceof Viagem)) {
            return false;
        }
        Viagem other = (Viagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Viagem[ id=" + id + " ]";
    }
}
