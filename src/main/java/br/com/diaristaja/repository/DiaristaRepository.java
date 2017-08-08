package br.com.diaristaja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.diaristaja.model.Diarista;

public interface DiaristaRepository extends JpaRepository<Diarista, Long> {
	
	
//	@Query(value="SELECT * FROM Diarista d WHERE"
//			+ " (SELECT * FROM DIARISTA_RESTRICAO dr WHERE d.id == dr.id_diarista AND"
//			+ "dr.id_restricao NOT IN :restricoesId)", nativeQuery = true)
	@Query(value="SELECT d FROM Diarista AS d LEFT JOIN  d.restricoes AS r WHERE r.id NOT IN (:restricoesId)")
	public List<Diarista> getDiaristasFiltradasPorRestricao(@Param("restricoesId") List<Long> restricoesId);

}
