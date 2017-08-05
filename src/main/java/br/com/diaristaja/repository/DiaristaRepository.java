package br.com.diaristaja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.diaristaja.model.Diarista;

public interface DiaristaRepository extends JpaRepository<Diarista, Long> {
	
	
	@Query(value="SELECT * FROM Diarista d WHERE"
			+ " (SELECT * FROM DIARISTA_RESTRICAO dr WHERE d.id == dr.id_diarista AND"
			+ "dr.id_restricao NOT IN :restricoesId)", nativeQuery = true)
//	select * from diarista d where d.id not in (select id_diarista from diarista_restricao  )
	public List<Diarista> getDiaristasFiltradasPorRestricao(@Param("restricoesId") List<Long> restricoesId);

}
