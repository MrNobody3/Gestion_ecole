package org.ensah.service.impl;

import org.ensah.domains.Professeur;
import org.ensah.repos.ProfesseurRepos;
import org.ensah.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ProfesseurServiceImpl implements ProfesseurService{
	@Autowired
	ProfesseurRepos professeurRepos;
	@Override
	public Professeur getProfesseur(Long id) {
		
		return professeurRepos.findOne(id);
	}
	
}
