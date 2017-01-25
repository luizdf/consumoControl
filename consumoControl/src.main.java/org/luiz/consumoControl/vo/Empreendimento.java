package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMPREENDIMENTO database table.
 * 
 */
@Entity
@Table(name="empreendimento")
@NamedQueries({@NamedQuery(name = "Empreendimento.findById", query = "SELECT o FROM Empreendimento o WHERE o.id = :id"),
	@NamedQuery(name = "Empreendimento.findAll", query = "SELECT o FROM Empreendimento o")})
public class Empreendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String endereco;

	@Column
	private String nome;

	@Column
	private String numero;

	//bi-directional many-to-one association to Consumo
	@OneToMany(mappedBy="empreendimento")
	private List<Consumo> consumos;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	private Municipio municipio;

	//bi-directional many-to-one association to Unidade
	@OneToMany(mappedBy="empreendimento")
	private List<Unidade> unidades;

	public Empreendimento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		consumo.setEmpreendimento(this);

		return consumo;
	}

	public Consumo removeConsumo(Consumo consumo) {
		getConsumos().remove(consumo);
		consumo.setEmpreendimento(null);

		return consumo;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Unidade> getUnidades() {
		return this.unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Unidade addUnidade(Unidade unidade) {
		getUnidades().add(unidade);
		unidade.setEmpreendimento(this);

		return unidade;
	}

	public Unidade removeUnidade(Unidade unidade) {
		getUnidades().remove(unidade);
		unidade.setEmpreendimento(null);

		return unidade;
	}

}