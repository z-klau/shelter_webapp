package pl.shelterwebapp.dao;

import java.util.List;

import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.form.DogSearchForm;

public interface DogDao {
	List<Dog> getAllDogs();

	Dog saveDog(Dog dog);

	void deleteDog(Long id);

	List<Dog> getDogSearchList(DogSearchForm searchForm);

}
