package org.ensah.repos;

import org.ensah.domains.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepos extends JpaRepository<Professeur, Long>{

}
