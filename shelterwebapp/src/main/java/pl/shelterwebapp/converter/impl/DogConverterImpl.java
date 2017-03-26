package pl.shelterwebapp.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.shelterwebapp.DTO.DogDTO;
import pl.shelterwebapp.converter.ObjectConverter;
import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.util.MyDateFormatter;

@Service
public class DogConverterImpl implements ObjectConverter<Dog, DogDTO>{
	
	@Autowired
	MyDateFormatter MDF;

	@Override
	public DogDTO convert(Dog dog) {
		DogDTO dogDTO = new DogDTO(
				dog.getId(),
				dog.getName(), 
				dog.getSex(), 
				dog.getRace(), 
				dog.getWeight(), 
				dog.getPlaceOfFind(), 
				MDF.formatToString(dog.getDateOfFind()), 
				dog.getPen().getName(),
				dog.getPen().getId());
		return dogDTO;
	}
	
	

}
