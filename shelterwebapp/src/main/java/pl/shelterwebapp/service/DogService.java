package pl.shelterwebapp.service;

import java.util.List;

import pl.shelterwebapp.domain.Dog;

public interface DogService {

	List<Dog> getAllDogs();

	Dog saveDog(Dog dog);

	void deleteDog(Long id);


}
