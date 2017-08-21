package br.com.diaristaja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.diaristaja.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	static final String HAVERSINE_PART = "(6371 * acos(cos(radians(:latitude)) * cos(radians(e.latitude)) * cos(radians(e.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(e.latitude))))";

	@Query("SELECT e.id FROM Endereco e WHERE "+HAVERSINE_PART+" < :distance ORDER BY "+HAVERSINE_PART+" DESC")
	public List<Long> getEnderecosByLatLong(@Param("latitude") final String latitude, @Param("longitude") final String longitude, @Param("distance") final double distance);

}
