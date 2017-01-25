package org.luiz.consumoControl.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQueries({@NamedQuery(name = "Usuario.findById", query = "SELECT o FROM Usuario o WHERE o.id = :id"),
	@NamedQuery(name = "Usuario.findByLogin", query = "SELECT o FROM Usuario o WHERE o.login = :login"),
	@NamedQuery(name = "Usuario.findAll", query = "SELECT o FROM Usuario o")})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	@Column
	private String login;
	@Column
	private String senha;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="usuario")
	private List<Pessoa> pessoas;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setUsuario(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setUsuario(null);

		return pessoa;
	}
}