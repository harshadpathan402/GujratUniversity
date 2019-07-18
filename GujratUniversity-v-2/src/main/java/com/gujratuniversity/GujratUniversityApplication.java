package com.gujratuniversity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.gujratuniversity.domain.Candidate;
import com.gujratuniversity.domain.EntranceExam;
import com.gujratuniversity.domain.Institute;
import com.gujratuniversity.hibernateconfiguration.JPAConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class GujratUniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(GujratUniversityApplication.class, args);
		
		JPAConfiguration configuration = new JPAConfiguration();
		EntityManager entityManager = configuration.createEntityManager("jdbc:postgresql://localhost:5432/gujrat_university", "jbilling", "");
		
		Institute institute =  new Institute();
		institute.setInstituteName("Indian");
		
		Candidate candidate1 = new Candidate("Harshad", 29, "G", 68, 4, "Test", 50);
		candidate1.setInstitute(institute);
		Candidate candidate2 = new Candidate("Sumit", 29, "G", 68, 4, "Test", 50);
		candidate2.setInstitute(institute);
		Candidate candidate3 = new Candidate("Ravi", 29, "P", 68, 4, "Test", 50);
		candidate3.setInstitute(institute);
		Candidate candidate4 = new Candidate("Dipak", 29, "P", 68, 4, "Test", 50);
		candidate4.setInstitute(institute);
		
		List<Candidate> candidates = new ArrayList<>();
		candidates.add(candidate1);
		candidates.add(candidate2);
		candidates.add(candidate3);
		candidates.add(candidate4);
		
		institute.setCandidates(candidates);
		
		EntranceExam entranceExam = new EntranceExam();
		
		entranceExam.setCandidateCount(5);
		entranceExam.setExamFee(12.15);
		entranceExam.setExamName("AIEEE");
		institute.setEntranceExams(Collections.singletonList(entranceExam));
		entranceExam.setInstitute(institute);
		
		entityManager.getTransaction().begin();
		entityManager.persist(institute);
		entityManager.getTransaction().commit();
		
	}

}
