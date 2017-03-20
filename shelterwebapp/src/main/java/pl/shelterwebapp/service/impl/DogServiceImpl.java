package pl.shelterwebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.repository.DogRepository;
import pl.shelterwebapp.service.DogService;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogRepository dogRepository;

	@Override
	public List<Dog> getAllDogs() {
		return dogRepository.findAll();
	}

	@Override
	public Dog saveDog(Dog dog) {
		return dogRepository.saveAndFlush(dog);
	}

	@Override
	public void deleteDog(Long id) {
		dogRepository.delete(id);
	}

}
