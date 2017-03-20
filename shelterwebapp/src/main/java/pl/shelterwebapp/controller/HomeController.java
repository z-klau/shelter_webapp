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
import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.form.DogForm;
import pl.shelterwebapp.service.DogService;
import pl.shelterwebapp.service.PenService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private PenService penService;

	@Autowired
	private DogService dogService;

	@Autowired
	private ObjectConverter<Dog, DogDTO> dogConverter;
	
	@Autowired
	private ObjectConverter<DogForm, Dog> dogFormConverter;


	@RequestMapping(method = RequestMethod.GET)
	public String homeView(Model model) {
		return "homeView";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addDogView(Model model) {
		model.addAttribute("penList", penService.getAllPens());
		model.addAttribute("dogForm", new DogForm());
		return "addView";
	}

	@RequestMapping(value = "/addDog", method = RequestMethod.POST)
	public String addDog(Model model, @ModelAttribute("dogForm") @Valid DogForm dogForm, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("penList", penService.getAllPens());
			return "addView";
		}
		dogService.saveDog(dogFormConverter.convert(dogForm));
		model.addAttribute("message", "Pomyœlnie dodano psa.");
		return addDogView(model);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showDogList(Model model) {
		List<DogDTO> dogList = (List<DogDTO>) dogConverter.convert(dogService.getAllDogs());
		model.addAttribute("dogList", dogList);
		model.addAttribute("penList", penService.getAllPens());
		model.addAttribute("editDogForm", new DogForm());
		return "listView";
	}
	
	@RequestMapping(value="/deleteDog", method=RequestMethod.POST)
	public String deleteDog(Model model, @RequestParam("dogId") Long dogId){
		dogService.deleteDog(dogId);
		model.addAttribute("message", "Pomyœlnie usuniêto psa.");
		return showDogList(model);
	}
	
	@RequestMapping(value="/editDog", method=RequestMethod.POST)
	public String editDog(Model model, @ModelAttribute("editDogForm") @Valid DogForm editDogForm, BindingResult errors){
		if(errors.hasErrors()){
			List<DogDTO> dogList = (List<DogDTO>) dogConverter.convert(dogService.getAllDogs());
			model.addAttribute("dogList", dogList);
			model.addAttribute("penList", penService.getAllPens());
			model.addAttribute("message", "Nie uda³o siê edytowaæ psa. B³êdnie wype³niony formularz.");
			return "listView";
		}
		dogService.saveDog(dogFormConverter.convert(editDogForm));
		model.addAttribute("message", "Pomyœlnie edytowano psa.");
		return showDogList(model);
	}
	
}
