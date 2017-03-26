package pl.shelterwebapp.dao;

import java.util.List;

import pl.shelterwebapp.domain.Pen;


public interface PenDao {
	List<Pen> getAllPens();

	Pen savePen(Pen pen);

	Pen findById(Long id);
}
