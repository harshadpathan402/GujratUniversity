package com.gujratuniversity.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Institute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String instituteName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "institute")
	private List<EntranceExam> entranceExams = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "institute")
	private List<Candidate> candidates = new ArrayList<>();
	
	public Institute() {
		//parameterless constructor
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public List<EntranceExam> getEntranceExams() {
		return entranceExams;
	}

	public void setEntranceExams(List<EntranceExam> entranceExams) {
		this.entranceExams = entranceExams;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	

}
