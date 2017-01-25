package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PESSOA database table.
 * 
 */
@Entity
@Table(name="pessoa")
@NamedQueries({@NamedQuery(name = "Pessoa.findById", query = "SELECT o FROM Pessoa o WHERE o.id = :id"),
	@NamedQuery(name = "Pessoa.findAll", query = "SELECT o FROM Pessoa o")})
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String cpf;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date datanascimento;

	@Column
	private String nome;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	private Unidade unidade;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	private Usuario usuario;

	public Pessoa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDatanascimento() {
		return this.datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}