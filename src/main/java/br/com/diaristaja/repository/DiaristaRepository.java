package br.com.diaristaja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.diaristaja.model.Diarista;

public interface DiaristaRepository extends JpaRepository<Diarista, Long> {
	
	
	@Query(value="SELECT DISTINCT (d) FROM Diarista d LEFT OUTER JOIN d.restricoes r WHERE r.id NOT IN (:restricoesId)")
	public List<Diarista> getDiaristasFiltradasPorRestricao(@Param("restricoesId") List<Long> restricoesId);

}
