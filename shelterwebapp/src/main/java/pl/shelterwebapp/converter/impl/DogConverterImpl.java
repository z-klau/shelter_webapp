package pl.shelterwebapp.converter.impl;

import org.springframework.stereotype.Service;

import pl.shelterwebapp.DTO.DogDTO;
import pl.shelterwebapp.converter.ObjectConverter;
import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.util.MyDateFormatter;

@Service
public class DogConverterImpl implements ObjectConverter<Dog, DogDTO>{

	@Override
	public DogDTO convert(Dog dog) {
		DogDTO dogDTO = new DogDTO(
				dog.getId(),
				dog.getName(), 
				dog.getSex(), 
				dog.getRace(), 
				dog.getWeight(), 
				dog.getPlaceOfFind(), 
				MyDateFormatter.formatToString(dog.getDateOfFind()), 
				dog.getPen().getName(),
				dog.getPen().getId());
		return dogDTO;
	}
	
	

}
