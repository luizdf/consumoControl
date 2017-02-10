package com.luizInfo.consumoControlSF.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizInfo.consumoControlSF.model.Pessoa;

public interface Pessoas extends JpaRepository<Pessoa, Long> {

	public List<Pessoa> findByNomeContainingIgnoreCase(String nome);
}
