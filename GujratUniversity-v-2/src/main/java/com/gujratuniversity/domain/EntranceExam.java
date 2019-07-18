package com.gujratuniversity.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EntranceExam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String examName;
	private double examFee;
	private Integer candidateCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id")
	private Institute institute;
	
	
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Institute getInstitute() {
		return institute;
	}


	public EntranceExam() {
	}


	public String getExamName() {
		return examName;
	}


	public void setExamName(String examName) {
		this.examName = examName;
	}


	public double getExamFee() {
		return examFee;
	}


	public void setExamFee(double examFee) {
		this.examFee = examFee;
	}


	public Integer getCandidateCount() {
		return candidateCount;
	}


	public void setCandidateCount(Integer candidateCount) {
		this.candidateCount = candidateCount;
	}
	
	
	
}
