package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UNIDADEMEDIDA database table.
 * 
 */
@Entity
@Table(name="unidademedida")
@NamedQueries({@NamedQuery(name = "UnidadeMedida.findById", query = "SELECT o FROM UnidadeMedida o WHERE o.id = :id"),
	@NamedQuery(name = "UnidadeMedida.findAll", query = "SELECT o FROM UnidadeMedida o")})
public class UnidadeMedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String nome;

	//bi-directional many-to-one association to Consumo
	@OneToMany(mappedBy="unidadeMedida")
	private List<Consumo> consumos;

	//bi-directional many-to-one association to Tarifa
	@OneToMany(mappedBy="unidadeMedida")
	private List<Tarifa> tarifas;

	//bi-directional many-to-one association to TipoConsumo
	@OneToMany(mappedBy="unidadeMedida")
	private List<TipoConsumo> tipoConsumos;

	public UnidadeMedida() {
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

	public List<Consumo> getConsumos() {
		return this.consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Consumo addConsumo(Consumo consumo) {
		getConsumos().add(consumo);
		consumo.setUnidadeMedida(this);

		return consumo;
	}

	public Consumo removeConsumo(Consumo consumo) {
		getConsumos().remove(consumo);
		consumo.setUnidadeMedida(null);

		return consumo;
	}

	public List<Tarifa> getTarifas() {
		return this.tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public Tarifa addTarifa(Tarifa tarifa) {
		getTarifas().add(tarifa);
		tarifa.setUnidadeMedida(this);

		return tarifa;
	}

	public Tarifa removeTarifa(Tarifa tarifa) {
		getTarifas().remove(tarifa);
		tarifa.setUnidadeMedida(null);

		return tarifa;
	}

	public List<TipoConsumo> getTipoConsumos() {
		return this.tipoConsumos;
	}

	public void setTipoConsumos(List<TipoConsumo> tipoConsumos) {
		this.tipoConsumos = tipoConsumos;
	}

	public TipoConsumo addTipoConsumo(TipoConsumo tipoConsumo) {
		getTipoConsumos().add(tipoConsumo);
		tipoConsumo.setUnidadeMedida(this);

		return tipoConsumo;
	}

	public TipoConsumo removeTipoConsumo(TipoConsumo tipoConsumo) {
		getTipoConsumos().remove(tipoConsumo);
		tipoConsumo.setUnidadeMedida(null);

		return tipoConsumo;
	}
}