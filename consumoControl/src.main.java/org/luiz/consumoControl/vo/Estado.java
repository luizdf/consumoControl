package org.luiz.consumoControl.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTADO database table.
 * 
 */
@Entity
@Table(name="estado")
@NamedQueries({@NamedQuery(name = "Estado.findById", query = "SELECT o FROM Estado o WHERE o.id = :id"),
	@NamedQuery(name = "Estado.findBySigla", query = "SELECT o FROM Estado o WHERE o.sigla = :sigla"),
	@NamedQuery(name = "Estado.findAll", query = "SELECT o FROM Estado o")})
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String nome;

	@Column
	private String sigla;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="estado")
	private List<Municipio> municipios;
	
	public Estado(){
		//Construtor Default
	}

	public Estado(String nome, String sigla) {
		this.setNome(nome);
		this.setSigla(sigla);
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

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Municipio> getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Municipio addMunicipio(Municipio municipio) {
		getMunicipios().add(municipio);
		municipio.setEstado(this);

		return municipio;
	}

	public Municipio removeMunicipio(Municipio municipio) {
		getMunicipios().remove(municipio);
		municipio.setEstado(null);

		return municipio;
	}

}