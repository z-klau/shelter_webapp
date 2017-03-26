package pl.shelterwebapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.shelterwebapp.DTO.DogDTO;
import pl.shelterwebapp.converter.ObjectConverter;
import pl.shelterwebapp.dao.DogDao;
import pl.shelterwebapp.dao.PenDao;
import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.form.DogForm;
import pl.shelterwebapp.form.DogSearchForm;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private PenDao penDao;

	@Autowired
	private DogDao dogDao;

	@Autowired
	private ObjectConverter<DogForm, Dog> dogFormConverter;

	@Autowired
	private ObjectConverter<Dog, DogDTO> dogConverter;

	@RequestMapping(method = RequestMethod.GET)
	public String getHomeView(Model model) {
		return "homeView";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddDogView(Model model) {
		model.addAttribute("penList", penDao.getAllPens());
		model.addAttribute("dogForm", new DogForm());
		return "addView";
	}

	@RequestMapping(value = "/addDog", method = RequestMethod.POST)
	public String addDog(Model model, @ModelAttribute("dogForm") @Valid DogForm dogForm, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("penList", penDao.getAllPens());
			return "addView";
		}
		dogDao.saveDog(dogFormConverter.convert(dogForm));
		model.addAttribute("message", "Pomyœlnie dodano psa.");
		return getAddDogView(model);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getDogList(Model model) {
		List<DogDTO> dogList = (List<DogDTO>) dogConverter.convert(dogDao.getAllDogs());
		model.addAttribute("dogList", dogList);
		model.addAttribute("penList", penDao.getAllPens());
		model.addAttribute("editDogForm", new DogForm());
		return "listView";
	}

	@RequestMapping(value = "/deleteDog", method = RequestMethod.POST)
	public String deleteDog(Model model, @RequestParam("dogId") Long dogId) {
		dogDao.deleteDog(dogId);
		model.addAttribute("message", "Pomyœlnie usuniêto psa.");
		return getDogList(model);
	}

	@RequestMapping(value = "/editDog", method = RequestMethod.POST)
	public String editDog(Model model, @ModelAttribute("editDogForm") @Valid DogForm editDogForm,
			BindingResult errors) {
		if (errors.hasErrors()) {
			List<DogDTO> dogList = (List<DogDTO>) dogConverter.convert(dogDao.getAllDogs());
			model.addAttribute("dogList", dogList);
			model.addAttribute("penList", penDao.getAllPens());
			model.addAttribute("message", "Nie uda³o siê edytowaæ psa. B³êdnie wype³niony formularz.");
			return "listView";
		}
		dogDao.saveDog(dogFormConverter.convert(editDogForm));
		model.addAttribute("message", "Pomyœlnie edytowano psa.");
		return getDogList(model);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getSearchView(Model model) {
		model.addAttribute("searchForm", new DogSearchForm());
		model.addAttribute("penList", penDao.getAllPens());
		return "searchView";
	}

	@RequestMapping(value = "/searchFor", method = RequestMethod.POST)
	public String searchForDog(Model model, @ModelAttribute("searchForm") DogSearchForm searchForm) {
		List<Dog> dogs = dogDao.getDogSearchList(searchForm);
		List<DogDTO> dogList = (List<DogDTO>) dogConverter.convert(dogs);
		model.addAttribute("dogList", dogList);
		return getSearchView(model);
	}

}
