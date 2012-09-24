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
@Table(name = "TRAJETO")
public class Trajeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TRAJETO")
    private Long id;
    @OneToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "CIDADE_ORIGEM")
    private Cidade cidadeOrigem;
    @OneToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "CIDADE_DESTINO")
    private Cidade cidadeDestino;
    @Column(name = "PRECO")
    private int preco;
    @Column(name = "DATA_INICIO")
    private String dataInicioViagem;
    @Column(name = "DATA_FIM")
    private String dataFimViagem;
    @Column(name = "HORA_INICIO")
    private String horaInicio;
    @Column(name = "HORA_FIM")
    private String horaFim;
    @OneToMany(mappedBy = "trajeto", targetEntity = Parada.class)
    private List<Parada> paradas;
    @OneToMany(mappedBy = "trajeto", targetEntity = Onibus.class)
    private List<Onibus> onibus;

    public Trajeto() {
    }

    public Trajeto(Cidade cidadeOrigem, Cidade cidadeDestino, int preco, String dataInicioViagem, String dataFimViagem, String horaInicio, String horaFim) {
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.preco = preco;
        this.dataInicioViagem = dataInicioViagem;
        this.dataFimViagem = dataFimViagem;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getDataFimViagem() {
        return dataFimViagem;
    }

    public void setDataFimViagem(String dataFimViagem) {
        this.dataFimViagem = dataFimViagem;
    }

    public String getDataInicioViagem() {
        return dataInicioViagem;
    }

    public void setDataInicioViagem(String dataInicioViagem) {
        this.dataInicioViagem = dataInicioViagem;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
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
        if (!(object instanceof Trajeto)) {
            return false;
        }
        Trajeto other = (Trajeto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Trajeto[ id=" + id + " ]";
    }
}
