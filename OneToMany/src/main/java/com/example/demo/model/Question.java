package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "question")
@Getter
@Setter
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String details;
	
	@OneToMany(
			mappedBy = "question",	// cart is the reference in Answer class
			cascade = CascadeType.ALL,	// 
			orphanRemoval = true	// if question removed, so is answer
			)
	private List<Answer> answers = new ArrayList<>();
	
	public Question (String details) {
		this.details = details;
	}
}
