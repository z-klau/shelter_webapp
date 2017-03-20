package pl.shelterwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.shelterwebapp.domain.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

}
