package pl.shelterwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.shelterwebapp.domain.Pen;

@Repository
public interface PenRepository extends JpaRepository<Pen, Long> {

	@Query(value = "SELECT p FROM Pen p LEFT JOIN FETCH p.dogs WHERE p.id = :id")
	Pen findById(@Param("id") Long id);

}
