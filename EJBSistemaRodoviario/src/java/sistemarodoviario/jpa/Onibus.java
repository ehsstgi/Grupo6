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
@Table(name = "ONIBUS")
public class Onibus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ONIBUS")
    private Long id;
    @Column(name = "NOME_EMPRESA")
    private String nomeEmpresa;
    @OneToMany(mappedBy = "onibus", fetch = FetchType.EAGER)
    private List<Assento> assentos;
    @ManyToOne
    @JoinColumn(name = "TRAJETO_FK")
    private Trajeto trajeto;

    public Onibus() {
    }

    public Onibus(String nomeEmpresa, List<Assento> assentos) {
        this.nomeEmpresa = nomeEmpresa;
        this.assentos = assentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Assento> getAssento() {
        return assentos;
    }

    public void setAssento(List<Assento> assentos) {
        this.assentos = assentos;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
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
        if (!(object instanceof Onibus)) {
            return false;
        }
        Onibus other = (Onibus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Onibus[ id=" + id + " ]";
    }
}
