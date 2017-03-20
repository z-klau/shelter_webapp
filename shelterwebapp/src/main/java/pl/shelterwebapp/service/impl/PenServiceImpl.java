package pl.shelterwebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.shelterwebapp.domain.Pen;
import pl.shelterwebapp.repository.PenRepository;
import pl.shelterwebapp.service.PenService;

@Service
public class PenServiceImpl implements PenService {

	@Autowired
	private PenRepository penRepositoryImpl;

	@Override
	public List<Pen> getAllPens() {
		return penRepositoryImpl.findAll();
	}

	@Override
	public Pen savePen(Pen pen) {
		return penRepositoryImpl.saveAndFlush(pen);
	}

	@Override
	public Pen findById(Long id) {
		return penRepositoryImpl.findById(id);
	}

}
