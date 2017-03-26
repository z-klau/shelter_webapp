package pl.shelterwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shelterwebapp.domain.Dog;

public interface DogRepository extends JpaRepository<Dog, Long> {

}
