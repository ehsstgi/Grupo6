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
@Table(name = "CIDADE")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CIDADE")
    private Long id;
    @Column(name = "NOME_CIDADE")
    private String nomeCidade;
    @ManyToOne
    @JoinColumn(name = "ESTADO_FK")
    private Estado estado;
    
    public Cidade() {
    }
    
    public Cidade(String nomeCidade, Estado estado) {
        this.nomeCidade = nomeCidade;
        this.estado = estado;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
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
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Cidade[ id=" + id + " Cidade=" + nomeCidade + "Estado=" + estado.toString() + "]";
    }
}
