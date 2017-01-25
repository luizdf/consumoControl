package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TARIFA database table.
 * 
 */
@Entity
@Table(name="tarifa")
@NamedQueries({@NamedQuery(name = "Tarifa.findById", query = "SELECT o FROM Tarifa o WHERE o.id = :id"),
	@NamedQuery(name = "Tarifa.findAll", query = "SELECT o FROM Tarifa o")})
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String enquadramento;

	@Column
	private String observacoes;

	@Column
	private float valorextra;

	@Column
	private float valorunitario;

	//bi-directional many-to-one association to Consumo
	@OneToMany(mappedBy="tarifa")
	private List<Consumo> consumos;

	//bi-directional many-to-one association to Unidademedida
	@ManyToOne
	private UnidadeMedida unidadeMedida;

	//bi-directional many-to-one association to Faixa
	@ManyToOne
	private Faixa faixa;

	//bi-directional many-to-one association to Competencia
	@ManyToOne
	private Competencia competencia;

	public Tarifa() {
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

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public float getValorextra() {
		return this.valorextra;
	}

	public void setValorextra(float valorextra) {
		this.valorextra = valorextra;
	}

	public float getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(float valorunitario) {
		this.valorunitario = valorunitario;
	}

	public List<Consumo> getConsumos() {
		return this.consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Consumo addConsumo(Consumo consumo) {
		getConsumos().add(consumo);
		consumo.setTarifa(this);

		return consumo;
	}

	public Consumo removeConsumo(Consumo consumo) {
		getConsumos().remove(consumo);
		consumo.setTarifa(null);

		return consumo;
	}

	public UnidadeMedida getUnidadeMedida() {
		return this.unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Faixa getFaixa() {
		return this.faixa;
	}

	public void setFaixa(Faixa faixa) {
		this.faixa = faixa;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

}