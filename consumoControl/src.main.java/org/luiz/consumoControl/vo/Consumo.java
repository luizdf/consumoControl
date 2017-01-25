package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONSUMO database table.
 * 
 */
@Entity
@Table(name="consumo")
@NamedQueries({@NamedQuery(name = "Consumo.findById", query = "SELECT o FROM Consumo o WHERE o.id = :id"),
	@NamedQuery(name = "Consumo.findAll", query = "SELECT o FROM Consumo o")})
public class Consumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private float valor;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	private Unidade unidade;

	//bi-directional many-to-one association to Empreendimento
	@ManyToOne
	private Empreendimento empreendimento;

	//bi-directional many-to-one association to Competencia
	@ManyToOne
	private Competencia competencia;

	//bi-directional many-to-one association to Unidademedida
	@ManyToOne
	private UnidadeMedida unidadeMedida;

	//bi-directional many-to-one association to TipoConsumo
	@ManyToOne
	private TipoConsumo tipoConsumo;

	//bi-directional many-to-one association to Tarifa
	@ManyToOne
	private Tarifa tarifa;

	public Consumo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Empreendimento getEmpreendimento() {
		return this.empreendimento;
	}

	public void setEmpreendimento(Empreendimento empreendimento) {
		this.empreendimento = empreendimento;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public UnidadeMedida getUnidadeMedida() {
		return this.unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public TipoConsumo getTipoConsumo() {
		return this.tipoConsumo;
	}

	public void setTipoConsumo(TipoConsumo tipoConsumo) {
		this.tipoConsumo = tipoConsumo;
	}

	public Tarifa getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

}