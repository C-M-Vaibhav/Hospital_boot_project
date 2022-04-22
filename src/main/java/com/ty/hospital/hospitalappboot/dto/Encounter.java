package com.ty.hospital.hospitalappboot.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	private LocalDate dateofAdmit;
	private String reason;

	@ManyToOne
	@JoinColumn(name = "Person_id")
	Person person;

	@ManyToOne
	@JoinColumn(name = "Branch_id")
	Branch branchs;

	@OneToMany(mappedBy = "encounter_id")
	List<Medorder> medOrders;

	public List<Medorder> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<Medorder> medOrders) {
		this.medOrders = medOrders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateofAdmit() {
		return dateofAdmit;
	}

	public void setDateofAdmit(LocalDate dateofAdmit) {
		this.dateofAdmit = dateofAdmit;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@JsonIgnore
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@JsonIgnore
	public Branch getBranchs() {
		return branchs;
	}

	public void setBranchs(Branch branchs) {
		this.branchs = branchs;
	}

}
