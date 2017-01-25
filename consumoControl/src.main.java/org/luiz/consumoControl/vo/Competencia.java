package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMPETENCIA database table.
 * 
 */
@Entity
@Table(name="competencia")
@NamedQueries({@NamedQuery(name = "Competencia.findById", query = "SELECT o FROM Competencia o WHERE o.id = :id"),
	@NamedQuery(name = "Competencia.findAll", query = "SELECT o FROM Competencia o")})
public class Competencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date datafim;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date datainicio;

	//bi-directional many-to-one association to Consumo
	@OneToMany(mappedBy="competencia")
	private List<Consumo> consumos;

	//bi-directional many-to-one association to Tarifa
	@OneToMany(mappedBy="competencia")
	private List<Tarifa> tarifas;

	public Competencia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatafim() {
		return this.datafim;
	}

	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	public Date getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public List<Consumo> getConsumos() {
		return this.consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Consumo addConsumo(Consumo consumo) {
		getConsumos().add(consumo);
		consumo.setCompetencia(this);

		return consumo;
	}

	public Consumo removeConsumo(Consumo consumo) {
		getConsumos().remove(consumo);
		consumo.setCompetencia(null);

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
		tarifa.setCompetencia(this);

		return tarifa;
	}

	public Tarifa removeTarifa(Tarifa tarifa) {
		getTarifas().remove(tarifa);
		tarifa.setCompetencia(null);

		return tarifa;
	}

}