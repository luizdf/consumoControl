package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FAIXA database table.
 * 
 */
@Entity
@Table(name="faixa")
@NamedQueries({@NamedQuery(name = "Faixa.findById", query = "SELECT o FROM Faixa o WHERE o.id = :id"),
	@NamedQuery(name = "Faixa.findAll", query = "SELECT o FROM Faixa o")})
public class Faixa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String nome;

	@Column
	private float valorFinal;

	@Column
	private float valorInicial;

	//bi-directional many-to-one association to Tarifa
	@OneToMany(mappedBy="faixa")
	private List<Tarifa> tarifas;

	public Faixa() {
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

	public float getValorFinal() {
		return this.valorFinal;
	}

	public void setValorFinal(float valorFinal) {
		this.valorFinal = valorFinal;
	}

	public float getValorInicial() {
		return this.valorInicial;
	}

	public void setValorInicial(float valorInicial) {
		this.valorInicial = valorInicial;
	}

	public List<Tarifa> getTarifas() {
		return this.tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public Tarifa addTarifa(Tarifa tarifa) {
		getTarifas().add(tarifa);
		tarifa.setFaixa(this);

		return tarifa;
	}

	public Tarifa removeTarifa(Tarifa tarifa) {
		getTarifas().remove(tarifa);
		tarifa.setFaixa(null);

		return tarifa;
	}

}