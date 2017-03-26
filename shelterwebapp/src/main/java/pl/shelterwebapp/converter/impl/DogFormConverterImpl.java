package pl.shelterwebapp.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.shelterwebapp.converter.ObjectConverter;
import pl.shelterwebapp.dao.PenDao;
import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.form.DogForm;

@Service
public class DogFormConverterImpl implements ObjectConverter<DogForm, Dog> {

	@Autowired
	private PenDao penDao;
	
	@Override
	public Dog convert(DogForm dogFrom) {
		Dog dog = new Dog(
				dogFrom.getId(),
				dogFrom.getName(), 
				dogFrom.getSex(), 
				dogFrom.getRace(), 
				dogFrom.getWeight(), 
				dogFrom.getPlaceOfFind(), 
				dogFrom.getDateOfFind(),
				penDao.findById(dogFrom.getPenId()));
		return dog;
	}

}
