package org.ensah.service.impl;

import javax.transaction.Transactional;

import org.ensah.domains.Compte;
import org.ensah.repos.CompteRepos;
import org.ensah.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class GuestServiceImpl implements GuestService{
	@Autowired
	private CompteRepos compteRepos;
	@Override
	public Compte signin(String username) {
		Compte compte=compteRepos.findByUsername(username);
		return compte;
	}

}
