package org.ensah.repos;

import org.ensah.domains.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepos extends JpaRepository<Compte, Long>{
	Compte findByUsername(String username);
}
