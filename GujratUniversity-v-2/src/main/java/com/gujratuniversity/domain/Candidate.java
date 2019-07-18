package com.gujratuniversity.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String  candidateName;
	private Integer age;
	private String  qualification;
	private Integer qualificationPercent;
	private Integer workExInSupervisoryCadre;
	private String  examName;
	private Integer entranceExamPercentage;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id")
	private Institute institute;
	
	public Candidate() {
	
	}
	
	//Constructor
	public Candidate(String candidateName, Integer age, String qualification, Integer qualificationPercent,
			Integer workExInSupervisoryCadre, String examName, Integer entranceExamPercentage) {
		this.candidateName = candidateName;
		this.age = age;
		this.qualification = qualification;
		this.qualificationPercent = qualificationPercent;
		this.workExInSupervisoryCadre = workExInSupervisoryCadre;
		this.examName = examName;
		this.entranceExamPercentage = entranceExamPercentage;
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

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public Integer getAge() {
		return age;
	}
	
	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public Integer getName() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Integer getQualificationPercent() {
		return qualificationPercent;
	}

	public void setQualificationPercent(Integer qualificationPercent) {
		this.qualificationPercent = qualificationPercent;
	}

	public Integer getWorkExInSupervisoryCadre() {
		return workExInSupervisoryCadre;
	}

	public void setWorkExInSupervisoryCadre(Integer workExInSupervisoryCadre) {
		this.workExInSupervisoryCadre = workExInSupervisoryCadre;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Integer getEntranceExamPercentage() {
		return entranceExamPercentage;
	}

	public void setEntranceExamPercentage(Integer entranceExamPercentage) {
		this.entranceExamPercentage = entranceExamPercentage;
	}
	
}
