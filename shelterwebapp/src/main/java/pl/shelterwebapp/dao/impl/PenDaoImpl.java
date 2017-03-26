package pl.shelterwebapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.shelterwebapp.dao.PenDao;
import pl.shelterwebapp.domain.Pen;
import pl.shelterwebapp.repository.PenRepository;

@Repository
@Transactional
public class PenDaoImpl implements PenDao {
	
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
