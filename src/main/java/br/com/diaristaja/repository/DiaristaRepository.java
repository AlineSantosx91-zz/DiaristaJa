package br.com.diaristaja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.diaristaja.model.Diarista;

public interface DiaristaRepository extends JpaRepository<Diarista, Long> {
	
	
	@Query(value="SELECT d FROM Diarista d WHERE d.id NOT IN (SELECT d2.id FROM Diarista d2 Join d2.restricoes r WHERE r.id IN (:restricoesId))")
	List<Diarista> getDiaristasFiltradasPorRestricao(@Param("restricoesId") List<Long> restricoesId);

}
