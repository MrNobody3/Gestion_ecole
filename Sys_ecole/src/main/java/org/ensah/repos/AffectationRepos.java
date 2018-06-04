package org.ensah.repos;

import java.util.List;

import org.ensah.domains.Affectation;
import org.ensah.domains.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface AffectationRepos extends JpaRepository<Affectation, Long>{
//	@Query("from Element natural join Affectation where id_prof=?1")
//	 List<Element> findElementbyIdprof(Long idProf);
}
