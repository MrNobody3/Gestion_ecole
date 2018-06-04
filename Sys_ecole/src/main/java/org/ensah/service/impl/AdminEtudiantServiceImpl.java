package org.ensah.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.ensah.domains.Etudiant;
import org.ensah.repos.EtudiantRepos;
import org.ensah.service.AdminEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminEtudiantServiceImpl implements AdminEtudiantService{
	
	@Autowired
	EtudiantRepos etudiantRepos;
	@Override
	public List<Etudiant> getEtudiants() {
		List<Etudiant> list=etudiantRepos.findAll();
		if(list==null)
			list=new ArrayList<Etudiant>();
		return list;
	}
	@Override
	public Etudiant getEtudiantbyCne(String cne) {
		Etudiant etd=etudiantRepos.findByCne(cne);
		if (etd == null){
			return null;
		}
		return etd;
	}
	@Override
	public Etudiant getEtudiant(Long id) {
		Etudiant etd=etudiantRepos.findOne(id);
		if (etd == null){
			throw new RuntimeException("Etudiant introuvable");
		}
		return etd;
	}
	@Override
	public List<Etudiant> getEtudiantMotCle(String motCle){
		List<Etudiant> list=etudiantRepos.findEtudiantsWordkey(motCle);
		if(list==null)
			return new ArrayList<Etudiant>();
		return list;
	}

}
