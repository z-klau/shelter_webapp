package shelterwebapp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.shelterwebapp.DTO.DogDTO;
import pl.shelterwebapp.converter.ObjectConverter;
import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.domain.Pen;
import pl.shelterwebapp.util.MyDateFormatter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConverterTestConfiguration.class)
public class ConverterTest {

	@Autowired
	private ObjectConverter<Dog, DogDTO> dogConverterImpl;

	List<Dog> dogs;

	@Before
	public void init() throws ParseException {

		dogs = new ArrayList<>();

		Pen p1 = new Pen("Brzozowy");
		p1.setId(3L);

		Dog d1 = new Dog(1L, "Albin", "M", "mieszaniec", 23.5, "Warszawa-Ochota",
				MyDateFormatter.parseToDate("2011-02-10"), p1);
		Dog d2 = new Dog(2L, "Muniek", "¯", "owczarek", 26.0, "£omianki", MyDateFormatter.parseToDate("2016-05-16"),
				p1);
		Dog d3 = new Dog(3L, "Burek", "M", "chihuahua", 3.4, "Warszawa-Centrum",
				MyDateFormatter.parseToDate("2012-07-12"), p1);

		dogs.add(d1);
		dogs.add(d2);
		dogs.add(d3);
	}

	@Test
	public void shouldConvertDogToDogDTO() {
		DogDTO dDTO = dogConverterImpl.convert(dogs.get(2));
		Assert.assertEquals("2012-07-12", dDTO.getDateOfFind());
		Assert.assertEquals(3.4, dDTO.getWeight(), 0);
		Assert.assertEquals("chihuahua", dDTO.getRace());
		Assert.assertEquals("Brzozowy", dDTO.getPenName());
	}

	@Test
	public void shouldConvertDogListToDogDTOList() {
		List<DogDTO> resultList = (List<DogDTO>) dogConverterImpl.convert(dogs);
		Assert.assertEquals(3, resultList.size());
		Assert.assertEquals(Long.valueOf(3L), resultList.get(0).getPenId());
	}

}
