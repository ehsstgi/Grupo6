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
@Table(name = "PARADA")
public class Parada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PARADA")
    private Long id;
    @Column(name = "HORARIO_PARADA")
    private String horarioParada;
    @OneToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "CIDADE_PARADA")
    private Cidade cidadeParada;
    @ManyToOne
    @JoinColumn(name = "TRAJETO_FK")
    private Trajeto trajeto;

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
        if (!(object instanceof Parada)) {
            return false;
        }
        Parada other = (Parada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Parada[ id=" + id + " ]";
    }
}
