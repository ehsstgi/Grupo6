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
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_FUNCIONARIO")
    private Long id;
    @Column(name = "USUARIO_FUNC", nullable = false)
    private String usuarioFunc;
    @Column(name = "NOME_FUNC", nullable = false)
    private String nomeFunc;
    @Column(name = "SENHA_FUNC", nullable = false)
    private String senhaFunc;
    @Column(name = "EMAIL_FUNC")
    private String email;

    public Funcionario() {
    }

    public Funcionario(String usuario, String nome, String senha) {
        this.usuarioFunc = usuario;
        this.nomeFunc = nome;
        this.senhaFunc = senha;
    }

    public Funcionario(String usuario, String nome, String senha, String email) {
        this.usuarioFunc = usuario;
        this.nomeFunc = nome;
        this.senhaFunc = senha;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getSenhaFunc() {
        return senhaFunc;
    }

    public void setSenhaFunc(String senhaFunc) {
        this.senhaFunc = senhaFunc;
    }

    public String getUsuarioFunc() {
        return usuarioFunc;
    }

    public void setUsuarioFunc(String usuarioFunc) {
        this.usuarioFunc = usuarioFunc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String resp = "ID:" + id + "Nome:" + nomeFunc + "Senha:" + senhaFunc;
        return resp;
    }
}
