package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPOCONSUMO database table.
 * 
 */
@Entity
@Table(name="tipoconsumo")
@NamedQueries({@NamedQuery(name = "TipoConsumo.findById", query = "SELECT o FROM TipoConsumo o WHERE o.id = :id"),
	@NamedQuery(name = "TipoConsumo.findAll", query = "SELECT o FROM TipoConsumo o")})
public class TipoConsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String nome;

	//bi-directional many-to-one association to Consumo
	@OneToMany(mappedBy="tipoConsumo")
	private List<Consumo> consumos;

	//bi-directional many-to-one association to Unidademedida
	@ManyToOne
	private UnidadeMedida unidadeMedida;

	public TipoConsumo() {
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
		consumo.setTipoConsumo(this);

		return consumo;
	}

	public Consumo removeConsumo(Consumo consumo) {
		getConsumos().remove(consumo);
		consumo.setTipoConsumo(null);

		return consumo;
	}

	public UnidadeMedida getUnidadeMedida() {
		return this.unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
}