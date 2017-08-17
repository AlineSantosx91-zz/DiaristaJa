package br.com.diaristaja.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.diaristaja.model.Diarista;
import br.com.diaristaja.model.Endereco;
import br.com.diaristaja.model.FiltroLocalizacao;

public interface DiaristaRepository extends JpaRepository<Diarista, Long> {
	
	static final String HAVERSINE_PART = "(6371 * acos(cos(radians(:latitude)) * cos(radians(e.latitude)) * cos(radians(e.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(e.latitude))))";

	
	
	@Query(value="SELECT d FROM Diarista d WHERE d.id NOT IN (SELECT d2.id FROM Diarista d2 Join d2.restricoes r WHERE r.id IN (:restricoesId))")
	List<Diarista> getDiaristasFiltradasPorRestricao(@Param("restricoesId") List<Long> restricoesId);

	
	@Query(value="SELECT id,(6371 * acos(cos( radians(?1) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?2) )+ sin( radians(?1) )* sin( radians( latitude ) ) )) AS distancia FROM endereco GROUP BY id having distancia < 25 order by distancia asc LIMIT 4;", nativeQuery=true)
	List<FiltroLocalizacao> getEnderecosByLatLong(String latitude, String longitude);
	
	@Query(value="SELECT d FROM Diarista d WHERE d.id IN (:enderecosId)")
	List<Diarista> getDiaristasFiltradasPorLocalizacao(@Param("enderecosId") List<Long> enderecosId);
	
	@Query("SELECT e.id FROM Endereco e WHERE "+HAVERSINE_PART+" < :distance ORDER BY "+HAVERSINE_PART+" DESC")
	public List<Long> getEnderecosByLatLong(@Param("latitude") final String latitude, @Param("longitude") final String longitude, @Param("distance") final double distance);

}
