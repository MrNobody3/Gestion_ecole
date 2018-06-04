package org.ensah;

import org.ensah.domains.Etudiant;

import java.util.Iterator;
import java.util.List;

import org.ensah.domains.Element;
import org.ensah.repos.ElementRepos;
import org.ensah.repos.EtudiantRepos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
//@EnableAutoConfiguration(exclude = { WebMvcAutoConfiguration.class })
//@ComponentScan("com.fasterxml.jackson.databind.Module")
@SpringBootApplication
public class SysEcoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysEcoleApplication.class, args);
//		try{
//			ApplicationContext ctx=SpringApplication.run(SysEcoleApplication.class, args);
//			ElementRepos elementRepos=ctx.getBean(ElementRepos.class);
//			List<Element> list=elementRepos.findElementByidProf(2L);
//			System.out.println("List des éléments");
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).getId()+" "+list.get(i).getNom());
//			}
//			Iterator<Element> iterator=list.iterator();
//			while(iterator.hasNext()){
//				System.out.println(iterator.next().getNom()+" "+iterator.next().getId());
//			}
//			Etudiant e=new Etudiant();
//			e.setCne("1311543654");
//			e.setEmail("z@gmail.com");
//			e.setNom("Tourabi");
//			e.setPrenom("Zakaria");
//			e.setPhoto("photo.jpg");
//			e.setSexe("male");
//			Etudiant e2=new Etudiant();
//			e2.setCne("1311543654");
//			e2.setEmail("zazaza@gmail.com");
//			e2.setNom("Tourabizaza");
//			e2.setPrenom("Zakariazaza");
//			e2.setPhoto("photozaza.jpg");
//			e2.setSexe("male");
//			etudiantRepos.save(e);
//			etudiantRepos.save(e2);
//
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
////		
//		System.out.println("Sa marche");
		
	}
}
