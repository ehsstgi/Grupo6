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
 * @author Renan
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CLIENTE")
    private Long id;
    @Column(name = "USUARIO_CLIENTE", nullable = false)
    private String usuarioCliente;
    @Column(name = "NOME_CLIENTE", nullable = false)
    private String nomeCliente;
    @Column(name = "SENHA_CLIENTE", nullable = false)
    private String senhaCliente;
    @Column(name = "DATA_NASC", nullable = false)
    private String dataCliente;
    @Column(name = "CPF_CLIENTE", nullable = false)
    private String cpfCliente;
    @Column(name = "RG_CLIENTE", nullable = false)
    private String rgCliente;
    @Column(name = "END_CLIENTE", nullable = true)
    private String endCliente;
    @Column(name = "COMPLEMENTO_END", nullable = false)
    private String complementoEnd;
    @Column(name = "TELEFONE_CLIENTE", nullable = true)
    private String telCliente;
    @Column(name = "CEL_CLIENTE", nullable = true)
    private String celCliente;
    @Column(name = "EMAIL_CLIENTE", nullable = true)
    private String emailCliente;
    @OneToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "CIDADE_CLIENTE")
    private Cidade cidadeCliente;
    @OneToOne(targetEntity = Estado.class)
    @JoinColumn(name = "ESTADO_CLIENTE")
    private Estado estadoCliente;
    @Column(name = "CARTAO_CLIENTE", nullable = false)
    private String cartaoCliente;
    @OneToMany(mappedBy = "cliente", targetEntity = Viagem.class)
    private List<Viagem> viagens;
    @OneToMany(mappedBy = "cliente", targetEntity = Pedido.class)
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(String nomeCliente, String cpfCliente, String usuarioCliente, String senhaCliente, String dataCliente, String rgCliente, String endCliente, String complementoEnd, Cidade cidadeCliente, Estado estadoCliente, String telCliente, String celCliente, String emailCliente, String cartaoCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.usuarioCliente = usuarioCliente;
        this.senhaCliente = senhaCliente;
        this.dataCliente = dataCliente;
        this.rgCliente = rgCliente;
        this.endCliente = endCliente;
        this.complementoEnd = complementoEnd;
        this.cidadeCliente = cidadeCliente;
        this.estadoCliente = estadoCliente;
        this.telCliente = telCliente;
        this.celCliente = celCliente;
        this.emailCliente = emailCliente;
        this.cartaoCliente = cartaoCliente;

    }
//GETTERS AND SETTERS

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCelCliente() {
        return celCliente;
    }

    public void setCelCliente(String celCliente) {
        this.celCliente = celCliente;
    }

    public Cidade getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(Cidade cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getComplementoEnd() {
        return complementoEnd;
    }

    public void setComplementoEnd(String complementoEnd) {
        this.complementoEnd = complementoEnd;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDataCliente() {
        return dataCliente;
    }

    public void setDataCliente(String dataCliente) {
        this.dataCliente = dataCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getEndCliente() {
        return endCliente;
    }

    public void setEndCliente(String endCliente) {
        this.endCliente = endCliente;
    }

    public Estado getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(Estado estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getCartaoCliente() {
        return cartaoCliente;
    }

    public void setCartaoCliente(String cartaoCliente) {
        this.cartaoCliente = cartaoCliente;
    }

// 
    @Override
    public String toString() {
        String resp = "ID:" + id + "Usuario:" + usuarioCliente + "Senha:" + senhaCliente;
        return resp;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}