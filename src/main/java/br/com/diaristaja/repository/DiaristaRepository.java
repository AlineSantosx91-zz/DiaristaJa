package br.com.diaristaja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.model.Restricao;

public interface DiaristaRepository extends JpaRepository<Diarista, Long> {
	
	
	@Query(value="SELECT d FROM Diarista d WHERE d.restricoes NOT IN (:restricoes)")
	public List<Diarista> getDiaristasFiltradasPorRestricao(@Param("restricoes") List<Restricao> restricoes);

}
