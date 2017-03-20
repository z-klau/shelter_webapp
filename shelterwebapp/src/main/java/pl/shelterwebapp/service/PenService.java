package pl.shelterwebapp.service;

import java.util.List;

import pl.shelterwebapp.domain.Pen;

public interface PenService {

	List<Pen> getAllPens();

	Pen savePen(Pen pen);
	
	Pen findById(Long id);

}
