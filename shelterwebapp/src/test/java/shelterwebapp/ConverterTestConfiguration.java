package shelterwebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.shelterwebapp.DTO.DogDTO;
import pl.shelterwebapp.converter.ObjectConverter;
import pl.shelterwebapp.converter.impl.DogConverterImpl;
import pl.shelterwebapp.domain.Dog;


@Configuration
public class ConverterTestConfiguration {
	
	@Bean
	public ObjectConverter<Dog, DogDTO> dogConverter() {
		return new DogConverterImpl();
	}
	
	
}
