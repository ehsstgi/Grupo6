/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "ASSENTO")
public class Assento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ASSENTO")
    private Long id;
    @Column(name = "LOCAL_ASSENTO")
    private String localAssento;
    @Column(name = "DISPONIBILIDADE")
    private boolean disponibilidadeAssento;
    @ManyToOne
    @JoinColumn(name = "ONIBUS_FK")
    private Onibus onibus;

    public Assento() {
    }

    public Assento(String localAssento, boolean disponibilidadeAssento, Onibus onibus) {
        this.localAssento = localAssento;
        this.disponibilidadeAssento = disponibilidadeAssento;
        this.onibus = onibus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDisponibilidadeAssento() {
        return disponibilidadeAssento;
    }

    public void setDisponibilidadeAssento(boolean disponibilidadeAssento) {
        this.disponibilidadeAssento = disponibilidadeAssento;
    }

    public Onibus getEstado() {
        return onibus;
    }

    public void setEstado(Onibus onibus) {
        this.onibus = onibus;
    }

    public String getLocalAssento() {
        return localAssento;
    }

    public void setLocalAssento(String localAssento) {
        this.localAssento = localAssento;
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
        if (!(object instanceof Assento)) {
            return false;
        }
        Assento other = (Assento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Assento[ id=" + id + " ]";
    }
}
