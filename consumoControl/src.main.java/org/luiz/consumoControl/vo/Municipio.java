package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MUNICIPIO database table.
 * 
 */
@Entity
@Table(name="municipio")
@NamedQueries({@NamedQuery(name = "Municipio.findById", query = "SELECT o FROM Municipio o WHERE o.id = :id"),
	@NamedQuery(name = "Municipio.findAll", query = "SELECT o FROM Municipio o")})
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@OneToMany(mappedBy="municipio")
	private List<Empreendimento> empreendimentos;

	@ManyToOne
	private Estado estado;

	public Municipio() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Empreendimento> getEmpreendimentos() {
		return this.empreendimentos;
	}

	public void setEmpreendimentos(List<Empreendimento> empreendimentos) {
		this.empreendimentos = empreendimentos;
	}

	public Empreendimento addEmpreendimento(Empreendimento empreendimento) {
		getEmpreendimentos().add(empreendimento);
		empreendimento.setMunicipio(this);

		return empreendimento;
	}

	public Empreendimento removeEmpreendimento(Empreendimento empreendimento) {
		getEmpreendimentos().remove(empreendimento);
		empreendimento.setMunicipio(null);

		return empreendimento;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}