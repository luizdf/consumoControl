package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UNIDADE database table.
 * 
 */
@Entity
@Table(name="unidade")
@NamedQueries({@NamedQuery(name = "Unidade.findById", query = "SELECT o FROM Unidade o WHERE o.id = :id"),
	@NamedQuery(name = "Unidade.findAll", query = "SELECT o FROM Unidade o")})
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String enquadramento;

	@Column
	private String numero;

	//bi-directional many-to-one association to Consumo
	@OneToMany(mappedBy="unidade")
	private List<Consumo> consumos;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="unidade")
	private List<Pessoa> pessoas;

	//bi-directional many-to-one association to Empreendimento
	@ManyToOne
	private Empreendimento empreendimento;

	public Unidade() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnquadramento() {
		return this.enquadramento;
	}

	public void setEnquadramento(String enquadramento) {
		this.enquadramento = enquadramento;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Consumo> getConsumos() {
		return this.consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Consumo addConsumo(Consumo consumo) {
		getConsumos().add(consumo);
		consumo.setUnidade(this);

		return consumo;
	}

	public Consumo removeConsumo(Consumo consumo) {
		getConsumos().remove(consumo);
		consumo.setUnidade(null);

		return consumo;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setUnidade(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setUnidade(null);

		return pessoa;
	}

	public Empreendimento getEmpreendimento() {
		return this.empreendimento;
	}

	public void setEmpreendimento(Empreendimento empreendimento) {
		this.empreendimento = empreendimento;
	}

}