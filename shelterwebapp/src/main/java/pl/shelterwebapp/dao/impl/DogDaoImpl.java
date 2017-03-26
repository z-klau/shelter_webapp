package pl.shelterwebapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.shelterwebapp.dao.DogDao;
import pl.shelterwebapp.domain.Dog;
import pl.shelterwebapp.domain.Pen;
import pl.shelterwebapp.form.DogSearchForm;
import pl.shelterwebapp.repository.DogRepository;

@Repository
@Transactional
public class DogDaoImpl implements DogDao {

	@Autowired
	EntityManager em;

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

	@Override
	public List<Dog> getDogSearchList(DogSearchForm searchForm) {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Dog> query = cb.createQuery(Dog.class);

		Root<Dog> dog = query.from(Dog.class);
		Join<Dog, Pen> pen = dog.join("pen");

		List<Predicate> predicates = new ArrayList<>();

		if (!searchForm.getName().isEmpty()) {
			Predicate hasName = cb.like(dog.get("name"), "%" + searchForm.getName() + "%");
			predicates.add(hasName);
		}

		if (searchForm.getSex() != null) {
			Predicate hasSex = cb.equal(dog.get("sex"), searchForm.getSex());
			predicates.add(hasSex);
		}

		if (!searchForm.getRace().isEmpty()) {
			Predicate hasRace = cb.like(dog.get("race"), "%" + searchForm.getRace() + "%");
			predicates.add(hasRace);
		}

		Predicate hasWeight;
		if (searchForm.getWeightFrom() != 0.0 && searchForm.getWeightTo() != 0.0) {
			hasWeight = cb.between(dog.get("weight"), searchForm.getWeightFrom(), searchForm.getWeightTo());
			predicates.add(hasWeight);
		} else if (searchForm.getWeightFrom() != 0.0) {
			hasWeight = cb.ge(dog.get("weight"), searchForm.getWeightFrom());
			predicates.add(hasWeight);
		} else if (searchForm.getWeightTo() != 0.0) {
			hasWeight = cb.le(dog.get("weight"), searchForm.getWeightTo());
			predicates.add(hasWeight);
		}

		if (!searchForm.getPlaceOfFind().isEmpty()) {
			Predicate hasPlaceOfFind = cb.like(dog.get("placeOfFind"), "%" + searchForm.getPlaceOfFind() + "%");
			predicates.add(hasPlaceOfFind);
		}

		Predicate hasDateOfFind;
		if (searchForm.getDateOfFindFrom() != null && searchForm.getDateOfFindTo() != null) {
			hasDateOfFind = cb.between(dog.get("dateOfFind"), searchForm.getDateOfFindFrom(),
					searchForm.getDateOfFindTo());
			predicates.add(hasDateOfFind);
		} else if (searchForm.getDateOfFindFrom() != null) {
			hasDateOfFind = cb.greaterThanOrEqualTo(dog.get("dateOfFind"), searchForm.getDateOfFindFrom());
			predicates.add(hasDateOfFind);
		} else if (searchForm.getDateOfFindTo() != null) {
			hasDateOfFind = cb.lessThanOrEqualTo(dog.get("dateOfFind"), searchForm.getDateOfFindTo());
			predicates.add(hasDateOfFind);
		}

		if (searchForm.getPenId() != null) {
			Predicate hasPen = cb.equal(pen.get("id"), searchForm.getPenId());
			predicates.add(hasPen);
		}
		
		
		Predicate[] restrictions = predicates.toArray(new Predicate[predicates.size()]);

		query.where(restrictions);


		List<Dog> list = em.createQuery(query.select(dog)).getResultList();
		return list;
	}
}
